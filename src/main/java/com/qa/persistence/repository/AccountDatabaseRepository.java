package com.qa.persistence.repository;

import java.util.Collection;

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
public class AccountDatabaseRepository implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil json;

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
	public String createAccount(String account) {

		Account acc1 = json.getObjectForJSON(account, Account.class);

		em.getTransaction().begin();
		em.persist(acc1);
		em.getTransaction().commit();

		return "{\"message\": \"New Account Created\"}";

	}

	@Transactional(TxType.REQUIRED)
	public String updateAccount(int accountNo, String account) {

		Account oldAcc = em.find(Account.class, accountNo);
		Account newAcc = json.getObjectForJSON(account, Account.class);

		em.getTransaction().begin();
		em.detach(oldAcc);
		oldAcc = newAcc;
		em.merge(oldAcc);
		em.getTransaction().commit();

		return "{\"message\": \"Updated Account\"}";
	}

	@Transactional(TxType.REQUIRED)
	public String deleteAccount(int accountNo) {

		Account acc1 = em.find(Account.class, accountNo);

		em.getTransaction().begin();
		em.remove(acc1);
		em.getTransaction().commit();

		return "{\"message\": \"Account Deleted\"}";
	}

}
