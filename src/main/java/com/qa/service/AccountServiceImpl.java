package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository repo;

	@Override
	public String getAllAccounts() {

		return repo.getAllAccounts();
	}

	@Override
	public String addAccount(String account) {

		return repo.createAccount(account);
	}

	@Override
	public String getAccount(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAccount(String account, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAccount(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
