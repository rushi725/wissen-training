package com.rushabh.service;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rushabh.model.Account;
import com.rushabh.model.Transaction;
import com.rushabh.model.TransactionType;
import com.rushabh.repository.AccountRepository;
@Service("txrService")
public class NEFTTxrService implements TxrService {

	private static final Logger LOGGER = Logger.getLogger("App");

	private AccountRepository accountRepository;
	
	@Autowired 
	public NEFTTxrService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		LOGGER.info("NEFTTxrService created with accountRepository");
	}
	
	@Transactional
	@Override
	public boolean transfer(double amount, String fromAccNum, String toAccNum) {
		LOGGER.info("Txr initiated");

		Account fromAccount = accountRepository.load(fromAccNum);
		Account toAccount = accountRepository.load(toAccNum);

		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		toAccount.setBalance(toAccount.getBalance()+amount);
		
		accountRepository.update(fromAccount);
		boolean b = false;
		if (b)
			throw new RuntimeException("ooops");
		accountRepository.update(toAccount);
		
		Transaction transaction = new Transaction();
		transaction.setAccount(toAccount);
		transaction.setAmount(amount);
		transaction.setClosingBalance(toAccount.getBalance());
		transaction.setType(TransactionType.CREDIT);
		transaction.setDateTime(LocalDateTime.now());
		accountRepository.addTransaction(transaction);
		
		transaction.setAccount(fromAccount);
		transaction.setAmount(amount);
		transaction.setClosingBalance(fromAccount.getBalance());
		transaction.setType(TransactionType.DEBIT);
		transaction.setDateTime(LocalDateTime.now());
		accountRepository.addTransaction(transaction);
		

		LOGGER.info("Txr finished");
		return true;

	}

}