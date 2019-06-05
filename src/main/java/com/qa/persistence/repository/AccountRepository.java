package com.qa.persistence.repository;

public interface AccountRepository {

	String getAllAccounts();

	String createAccount(String account);

	String deleteAccount(int accountNo);

	String updateAccount(int accountNo, String account);

}
