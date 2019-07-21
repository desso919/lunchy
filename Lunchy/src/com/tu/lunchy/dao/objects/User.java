 package com.tu.lunchy.dao.objects;

public class User {

	private int userId;	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int accountTypeId;
	
	public User() {
	}
	
	public User(String username, String password, int accountType) {
		this.username = username;
		this.password = password;
		this.accountTypeId = accountType;
	}
	
	public User(int userId, String username, String password, int accountType) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.accountTypeId = accountType;
	}

	public User(int userId, String firstName, String lastName, String username, String password, int accountTypeId) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.accountTypeId = accountTypeId;
	}
	
	public User(String firstName, String lastName, String username, String password, int accountTypeId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.accountTypeId = accountTypeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAccountType() {
		return accountTypeId;
	}

	public void setAccountType(int accountType) {
		this.accountTypeId = accountType;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", accountTypeId="
				+ accountTypeId + "]";
	}

	
}
