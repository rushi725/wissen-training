package com.rushabh.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.rushabh.model.Account;
import com.rushabh.model.Transaction;
@Service("jpaAccountRepository")
public class JpaAccountRepository implements AccountRepository {
	
	
	@PersistenceContext
	private EntityManager em;

	private static final Logger LOGGER = Logger.getLogger("App");

	public JpaAccountRepository() {
		LOGGER.info("JpaAccountRepository created");
	}

	public Account load(String accNum) {
		LOGGER.info("loading account : " + accNum);
		return em.find(Account.class, accNum);
	

	}

	public Account update(Account account) {
		//
		LOGGER.info("updating account : " + account.getNumber());
		return em.merge(account);
	}

	@Override
	public void addTransaction(Transaction transaction) {
		
		LOGGER.info("Transaction added");
		em.persist(transaction);
		
	}

	@Override
	public List<Transaction> getTransactions(String accountNum) {
		LOGGER.info("Transaction added " + accountNum);
		List<Transaction> list = new ArrayList<>();
		Query q1 = em.createQuery("from Account a where a.number = ?1");
		q1.setParameter(1, accountNum);
		Account acc = (Account) q1.getSingleResult();
		Query query = em.createQuery("FROM Transaction t where t.account = :acc");
		query.setParameter("acc", acc);

		
		list = query.getResultList();
		return list;
	}

}