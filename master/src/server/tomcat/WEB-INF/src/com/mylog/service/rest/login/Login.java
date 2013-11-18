package com.mylog.service.rest.login;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import com.mylog.dao.AppUser;
import com.mylog.dao.EntityManagerHelper;

@Path("login")
public class Login
{	
	static Object mutex = new Object();
	static int c = 0;
	
	@Context
	SecurityContext security;

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public LoginResult getLogin2()
		   throws Exception
	{
		//System.out.println("Security = " + security.getUserPrincipal().getName());

		int i;
		synchronized (mutex) {
			i = (c++);
		}
		
	   EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
	   em.getTransaction().begin();
	   AppUser user = new AppUser();
	   user.setUserId("morne-" + (i));
	   user.setLoginName("Morne");
	   em.persist(user);

	   em.getTransaction().commit();
		//for (int i = 0; i< 100000; i++) i++;

	   return  new LoginResult(false, "Some error message 2");
	}

}
