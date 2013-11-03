package com.mylog.security;

import javax.servlet.http.HttpServletRequest;



public class SecurityManager
{
	private static SecurityManager instance = new SecurityManager();

	private SecurityManager()
	{

	}

	public static SecurityManager getInstance ()
	{
		return instance;
	}

	public boolean login (HttpServletRequest request, String user_name, String password)
	{

		request.getSession(true);
		return true;
	}

}
