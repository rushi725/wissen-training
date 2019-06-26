package com.rushabh.repository;

import com.rushabh.model.Account;
import com.rushabh.model.Transaction;

public interface AccountRepository {

	Account load(String accNum);

	Account update(Account account);
	
	void addTransaction(Transaction transaction);

}