package com.mylog.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper
{
	private static EntityManagerHelper instance = null;
	
	private EntityManagerFactory emf = null;
	
	private EntityManagerHelper()
	{
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	public static synchronized EntityManagerHelper getInstance ()
	{
		if (instance == null)
		{
			instance = new EntityManagerHelper();
		}
		
		return instance;
	}
	
	public EntityManager getEntityManager() throws Exception
	{
		return  emf.createEntityManager();
	}
	
	private static final String PERSISTENCE_UNIT_NAME = "MyLog";
}
