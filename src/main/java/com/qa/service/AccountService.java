package com.qa.service;

public interface AccountService {

	// C
	String addAccount(String account);

	// R
	String getAllAccounts();

	String getAccount(int id);

	// U
	String updateAccount(String account, int id);

	// D
	String deleteAccount(int id);

}
