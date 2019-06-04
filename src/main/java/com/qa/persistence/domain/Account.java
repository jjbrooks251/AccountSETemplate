package com.qa.persistence.domain;

public class Account {

	// This class needs to have:
	// An id
	// An Account Number
	// A First Name
	// A last Name

	private int id;
	private int accountNo;
	private String firstName;
	private String lastName;

	public Account(int id, int accountNo, String firstName, String lastName) {
		super();
		this.id = id;
		this.accountNo = accountNo;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
