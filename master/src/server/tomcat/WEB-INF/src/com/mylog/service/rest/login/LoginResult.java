package com.mylog.service.rest.login;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginResult
{
	public boolean successLogon;

	public String errorMessage;

	public int [] list = new int [] {1, 2, 3, 4, 5};

	public LoginResult()
	{

	}

	public LoginResult(boolean successLogon, String errorMessage) {
		super();
		this.successLogon = successLogon;
		this.errorMessage = errorMessage;
	}
}
