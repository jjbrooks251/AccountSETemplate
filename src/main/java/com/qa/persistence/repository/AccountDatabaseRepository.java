package com.qa.persistence.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class AccountDatabaseRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil json;

	private Map<Integer, Account> accountMap = new HashMap<Integer, Account>();

	public Map<Integer, Account> getAccountMap() {
		return accountMap;
	}

	public String getAllAccounts() {

		Query query = em.createQuery("SELECT a FROM Account a");

		Collection<Account> accounts = (Collection<Account>) query.getResultList();

		return json.getJSONForObject(accounts);
	}

	public String findAnAccount(int id) {
		Account acc1 = em.find(Account.class, id);

		return json.getJSONForObject(acc1);

	}

	@Transactional(TxType.REQUIRED)
	public String createAnAccount(String account) {

		Account acc1 = json.getObjectForJSON(account, Account.class);

		em.getTransaction().begin();
		em.persist(acc1);
		em.getTransaction().commit();

		return "{\"message\": \"New Account Created\"}";

	}

	@Transactional(TxType.REQUIRED)
	public String updateAnAccount(int accountNumber, String account) {

		Account oldAcc = em.find(Account.class, accountNumber);
		Account newAcc = json.getObjectForJSON(account, Account.class);

		em.getTransaction().begin();
		em.detach(oldAcc);
		oldAcc = newAcc;
		em.merge(oldAcc);
		em.getTransaction().commit();

		return "{\"message\": \"Updated Account\"}";
	}

	@Transactional(TxType.REQUIRED)
	public String deleteAccount(int id) {

		Account acc1 = em.find(Account.class, id);

		em.getTransaction().begin();
		em.remove(acc1);
		em.getTransaction().commit();

		return "{\"message\": \"Account Deleted\"}";
	}

}
