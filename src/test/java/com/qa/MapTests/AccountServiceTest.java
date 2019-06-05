package com.qa.MapTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	private JSONUtil jsonUtil;
	private AccountMapRepository amp;

	@Before
	public void setup() {
		jsonUtil = new JSONUtil();
		amp = new AccountMapRepository();

	}

	@Test
	public void addAccountTest() {

		Account acc = new Account(25, 1234, "John", "Smith");
		String accString = jsonUtil.getJSONForObject(acc);

		// assertEquals(1, amp.getAccountMap().size());

		assertEquals("Inserted new account", amp.createAccount(accString));

	}

	@Test
	public void add2AccountsTest() {

		Account acc1 = new Account(1, 1234, "John", "Hancock");
		String accString = jsonUtil.getJSONForObject(acc1);

		Account acc2 = new Account(2, 1234, "Jane", "doe");
		String accString2 = jsonUtil.getJSONForObject(acc2);

		assertEquals("Account not created", "Inserted new account", amp.createAccount(accString));
		assertEquals("Account not created", "Inserted new account", amp.createAccount(accString2));

		System.out.println(accString);
		System.out.println(accString2);

	}

	@Test
	public void removeAccountTest() {
		Account acc2 = new Account(2, 1234, "Jane", "doe");

		assertEquals("Account doesnt exist", "deleted chosen accounts", amp.deleteAccount(2));

	}

	@Test
	public void remove2AccountsTest() {

		Account acc1 = new Account(1, 1234, "John", "Hancock");
		String accString = jsonUtil.getJSONForObject(acc1);

		Account acc2 = new Account(2, 1234, "Jane", "doe");
		String accString2 = jsonUtil.getJSONForObject(acc2);

		assertEquals("Account doesnt exist", "deleted chosen accounts", amp.deleteAccount(1));
		assertEquals("Account doesnt exist", "deleted chosen accounts", amp.deleteAccount(2));

	}

	@Ignore
	public void remove2AccountTestAnd1ThatDoesntExist() {

	}

	@Ignore
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Ignore
	public void accountConversionToJSONTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Ignore
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Ignore
	public void getCountForFirstNamesInAccountWhenOne() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Ignore
	public void getCountForFirstNamesInAccountWhenTwo() {
		// For a later piece of functionality
		fail("TODO");
	}

}
