package com.mylog.service.rest.login;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginResult
{
	public boolean successLogon;

	public String errorMessage;

	/**
	 * Default constructor. This is required for JAXB, I think.
	 */
	public LoginResult()
	{

	}

	public LoginResult(boolean successLogon, String errorMessage) {
		super();
		this.successLogon = successLogon;
		this.errorMessage = errorMessage;
	}
}
