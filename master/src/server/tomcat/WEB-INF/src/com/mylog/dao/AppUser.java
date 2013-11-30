package com.mylog.dao;

import java.security.MessageDigest;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mylog.util.ApplicationLog;
import com.mylog.util.HexUtils;

@Entity
@Table(name = "AppUser")
public class AppUser {
	@Id
	private String UserId;	//Format: yyyymmddhhmmssnnnnnn

	@Basic
	private String LoginName;

	@Basic
	private String PasswordHash;	// The password hash in HEX, length 64

	@Basic
	private String Email;

	@OneToMany(mappedBy="appUser")
	private List<LogEntry> logEntries;

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getLoginName() {
		return LoginName;
	}

	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

	public String getPasswordHash() {
		return PasswordHash;
	}

	public void setPasswordHash(String passwordHash) {
		PasswordHash = passwordHash;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public List<LogEntry> getLogEntries()
	{
		return logEntries;
	}

	/**
	 * Calculates the password hash for a password in the clear
	 *
	 * @param passwordClear
	 * 			The password in the clear
	 *
	 * @return
	 * 			A hashed version of the password, in HEX string. Length 64.
	 */
	public static String getPasswordHash(String passwordClear)
	{
		if (passwordClear != null)
		{
			try
			{
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(passwordClear.getBytes());
				return HexUtils.bytesToHex(md.digest());
			}
			catch (Exception e)
			{
				ApplicationLog.getInstance().log(e.getMessage(), e);

				throw new RuntimeException(e.getMessage(), e);
			}
		}
		else
		{
			return null;
		}
	}
}
