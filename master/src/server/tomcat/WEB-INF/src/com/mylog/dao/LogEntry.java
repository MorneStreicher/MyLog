package com.mylog.dao;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "LogEntry")
public class LogEntry
{
	@Id
	private String Id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UserId")
	private AppUser appUser;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAdded;

	@Basic
	private int logDataVersion;

	@Basic
	private String logDataText;

	public LogEntry()
	{

	}

	public LogEntry(String id, AppUser appUser, Date dateAdded, int logDataVersion, String logDataText)
	{
		super();
		Id = id;
		this.appUser = appUser;
		this.dateAdded = dateAdded;
		this.logDataVersion = logDataVersion;
		this.logDataText = logDataText;
	}

	public String getId()
	{
		return Id;
	}

	public void setId(String id)
	{
		Id = id;
	}

	public AppUser getAppUser()
	{
		return appUser;
	}

	public void setAppUser(AppUser appUser)
	{
		this.appUser = appUser;
	}

	public Date getDateAdded()
	{
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded)
	{
		this.dateAdded = dateAdded;
	}

	public int getLogDataVersion()
	{
		return logDataVersion;
	}

	public void setLogDataVersion(int logDataVersion)
	{
		this.logDataVersion = logDataVersion;
	}

	public String getLogDataText()
	{
		return logDataText;
	}

	public void setLogDataText(String logDataText)
	{
		this.logDataText = logDataText;
	}





}
