package com.kshare.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AccountDTO implements Serializable{

	private static final long serialVersionUID = 280173961099133353L;

	private int accountId;

	private String name;

	private String emailId;
	
	private String userId;
	
	@JsonIgnore
	private String password;
	

	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDTO(int accountId, String name, String emailId, String userId, String password) {
		super();
		this.accountId = accountId;
		this.name = name;
		this.emailId = emailId;
		this.userId = userId;
		this.password = password;
	}

	public AccountDTO(String name, String emailId, String userId, String password) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.userId = userId;
		this.password = password;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountDTO other = (AccountDTO) obj;
		if (accountId != other.accountId)
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountDTO [accountId=" + accountId + ", name=" + name + ", emailId=" + emailId + ", userId=" + userId
				+ ", password=" + password + "]";
	}
	
	
}
