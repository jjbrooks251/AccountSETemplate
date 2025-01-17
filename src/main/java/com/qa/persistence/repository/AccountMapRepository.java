package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository {

	private Map<Integer, Account> accountMap = new HashMap<Integer, Account>();

	public Map<Integer, Account> getAccountMap() {
		return accountMap;
	}

	public void setAccountMap(Map<Integer, Account> accountMap) {
		this.accountMap = accountMap;
	}

	public JSONUtil getJson() {
		return json;
	}

	public void setJson(JSONUtil json) {
		this.json = json;
	}

	private JSONUtil json = new JSONUtil();
	// You must provide concrete implementation for each of these methods
	// do not change the method signature
	// THINK - if the parameter is a String, or the return type is a String
	// How can I convert to a String from an Object?
	// What utility methods do I have available?

	// You must complete this section using TDD
	// You can use the suggested tests or build your own.

	public String getAllAccounts() {

		return accountMap.toString();
	}

	public String createAccount(String account) {

		Account acc = json.getObjectForJSON(account, Account.class);

		accountMap.put(acc.getId(), acc);

		return "Inserted new account";
	}

	public String deleteAccount(int accountNo) {

		accountMap.remove(accountNo);

		return "deleted chosen accounts";
	}

	public String updateAccount(int accountNo, String account) {
		Account acc = json.getObjectForJSON(account, Account.class);

		accountMap.replace(accountNo, acc);

		return "Updated chosen accounts";
	}

	public int findAccount(String firstName) {

		// get accountMap size
		// Iterate through for all with given name
		// add to a counter
		// return value

		int count = 0;

		for (Integer i : accountMap.keySet()) {

			// get JSON string here for ith element

			String account = "fgdsfg";

			Account acc = json.getObjectForJSON(account, Account.class);

			String first = acc.getFirstName();

			if (first == firstName) {

				count = count + 1;

			}

		}

		return count;
	}

}
