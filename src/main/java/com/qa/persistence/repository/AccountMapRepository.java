package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;

public class AccountMapRepository implements AccountRepository {

	Map<Integer, Account> accountMap = new HashMap<Integer, Account>();

	// You must provide concrete implementation for each of these methods
	// do not change the method signature
	// THINK - if the parameter is a String, or the return type is a String
	// How can I convert to a String from an Object?
	// What utility methods do I have available?

	// You must complete this section using TDD
	// You can use the suggested tests or build your own.

	public String getAllAccounts() {

		return "returned all accounts";
	}

	public String createAccount(String account) {

		return "Inserted new account";
	}

	public String deleteAccount(int accountNo) {

		return "deleted chosen accounts";
	}

	public String updateAccount(int accountNo, String account) {

		return "Updated chosen accounts";
	}

}
