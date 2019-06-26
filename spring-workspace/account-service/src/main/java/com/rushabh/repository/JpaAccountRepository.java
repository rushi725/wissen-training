package com.rushabh.repository;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.rushabh.model.Account;
import com.rushabh.model.Transaction;
//@Service("jpaAccountRepository")
public class JpaAccountRepository implements AccountRepository {

	private static final Logger LOGGER = Logger.getLogger("App");

	public JpaAccountRepository() {
		LOGGER.info("JpaAccountRepository created");
	}

	public Account load(String accNum) {
		LOGGER.info("loading account : " + accNum);
		// ...
		return new Account("000000");
	}

	public Account update(Account account) {
		//
		LOGGER.info("updating account : " + account.getNumber());
		return null;
	}

	@Override
	public void addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}

}