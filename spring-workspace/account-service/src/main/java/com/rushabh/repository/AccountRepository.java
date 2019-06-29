package com.rushabh.repository;

import java.util.List;

import com.rushabh.model.Account;
import com.rushabh.model.Transaction;

public interface AccountRepository {

	Account load(String accNum);

	Account update(Account account);
	
	void addTransaction(Transaction transaction);
	
	List<Transaction> getTransactions(String accountNum);

}