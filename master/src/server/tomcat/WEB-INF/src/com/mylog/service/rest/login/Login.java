package com.mylog.service.rest.login;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.mylog.dao.AppUser;
import com.mylog.dao.EntityManagerHelper;
import com.mylog.service.MyLogSession;

@Path("login")
public class Login
{
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public LoginResult doLogin(
			@Context HttpServletRequest httpRequest,
			@QueryParam("userId") String userId,
			@QueryParam("password") String password)
		   throws Exception
	{
	   EntityManager em = EntityManagerHelper.getInstance().getEntityManager();

	   try
	   {
		   List list = em.createQuery(
		             "SELECT user from AppUser user where user.LoginName = :userId")
		             .setParameter("userId", userId).getResultList();

		   AppUser user = null;
		   if (list.size() > 0)
		   {
			   user = (AppUser)list.get(0);
		   }

		   if (user == null)
		   {
			   return new LoginResult(false, "The user ["+userId+"] does not exist.");
		   }
		   else
		   {
			   String hash = AppUser.getPasswordHash(password);
			   if (user.getPasswordHash().equals(hash))
			   {
				   MyLogSession session = new MyLogSession(httpRequest);
				   session.setAppUser(user);
				   return new LoginResult(true, null);
			   }
			   else
			   {
				   return new LoginResult(false, "Incorrect password for user ["+userId+"].");
			   }
		   }

	   }
	   finally
	   {
		   em.close();
	   }
	}
}
