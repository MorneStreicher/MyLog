package com.mylog.entries.budget;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.mylog.dao.AppUser;
import com.mylog.entries.def.AEntryObject;
import com.mylog.entries.def.AEntryObject.ValidationResult;

@XmlRootElement
public class BudgetEntry extends AEntryObject
{
	private String id;
	private Date date;
	private String description;
	private double amount;

	public BudgetEntry()
	{

	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void initForNewInstance(AppUser user) throws Exception
	{
		this.date = new Date();
		this.description = "Some test description";
	}

	public ValidationResult validateObject() throws Exception
	{
		return new ValidationResult(true, null, null, null);
	}

}
