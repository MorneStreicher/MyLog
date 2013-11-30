package com.mylog.entries.def;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

import com.mylog.dao.AppUser;
import com.mylog.dao.EntityManagerHelper;
import com.mylog.dao.LogEntry;
import com.mylog.service.MyLogSession;
import com.mylog.service.rest.login.LoginResult;

@XmlRootElement
public abstract class AEntryObject
{

	public abstract String getId();
	public abstract void setId(String id);

	public abstract void initForNewInstance(AppUser user) throws Exception;

	public void loadFromDatabase(String id) throws Exception
	{

	}

	public void saveToDataBase(MyLogSession session) throws Exception
	{
		if (getId() == null)
		{
			setId(UUID.randomUUID().toString());
		}

		JAXBContext jaxbContext = JAXBContext.newInstance(this.getClass());
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		//jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		jaxbMarshaller.marshal(this, os);
		String xml = new String(os.toByteArray());
		//System.out.println(xml);

		LogEntry logEntry = new LogEntry();
		logEntry.setId(this.getId());
		logEntry.setAppUser(session.getAppUser());
		logEntry.setDateAdded(new Date());
		logEntry.setLogDataVersion(1);
		logEntry.setLogDataText(xml);

		EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
		try
		{
			em.getTransaction().begin();
			em.persist(logEntry);
			em.getTransaction().commit();
		}
		finally
		{
			em.close();
		}
	}

	public void getFieldValuesMap(Map<String, String> map, EntryDefinition entryDef)
	{
		for (FieldDefinition cur : entryDef.getAllFields())
		{
			try
			{
				AEntryObjectValueMapper valueMapper = AEntryObjectValueMapper.getMapper(cur);

				Object value = this.getClass().getMethod("get" + cur.getName()).invoke(this);
				if (value != null)
				{
					map.put(cur.getName(), valueMapper.toString(value));
				}
			}
			catch (NoSuchMethodException e)
			{
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}

	public void setFieldValuesFromMap(Map<String, String> map, EntryDefinition entryDef)
	{
		for (FieldDefinition cur : entryDef.getAllFields())
		{
			try
			{
				if (map.containsKey(cur.getName()) && !"".equals(map.get(cur.getName())))
				{
					AEntryObjectValueMapper valueMapper = AEntryObjectValueMapper.getMapper(cur);

					this.getClass().getMethod("set" + cur.getName(), valueMapper.getValueClass())
							.invoke(this, valueMapper.fromString(map.get(cur.getName())));
				}
			}
			catch (NoSuchMethodException e)
			{
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}

	public abstract ValidationResult validateObject() throws Exception;

	public static class ValidationResult
	{

		// General feedback
		public boolean success = true;
		public String generalFeedback;

		// Field specific validation
		public String fieldName;
		public String fieldValidationMessage;

		public ValidationResult(boolean success, String generalFeedback, String fieldName,
				String fieldValidationMessage)
		{
			this.success = success;
			this.generalFeedback = generalFeedback;
			this.fieldName = fieldName;
			this.fieldValidationMessage = fieldValidationMessage;
		}

	}
}
