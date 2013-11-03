package com.mylog.service.rest.login;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("login")
public class Login
{

	@PersistenceContext
	private EntityManager em2;

   @GET
   //@Produces("text/plain")
   public String getHello()
   {
	   System.out.println ("EM2: " + em2);
	   return "Hello World, from REST!!!2";
   }
}
