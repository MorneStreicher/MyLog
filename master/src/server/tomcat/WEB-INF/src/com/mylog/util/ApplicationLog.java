package com.mylog.util;

/**
 * A utility class for logging requirements
 *
 */

public class ApplicationLog
{
	private static ApplicationLog instance = new ApplicationLog();

	/**
	 * Constructor.
	 *
	 */

	private ApplicationLog()
	{

	}

	/**
	 * Logs an error message to the application log
	 *
	 * @param message
	 * 			A test representation of the error
	 *
	 * @param t
	 * 			The exception that caused the error
	 *
	 */

	public synchronized void log(String message, Throwable t)
	{
		System.out.println ("ERROR: " + message);
		t.printStackTrace();
	}

	/**
	 *
	 * @return
	 * 		The instance of this singleton class
	 */

	public static ApplicationLog getInstance()
	{
		return instance;
	}
}
