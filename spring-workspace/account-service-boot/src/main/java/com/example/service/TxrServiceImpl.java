package com.example.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.TxnRepository;
import com.example.model.Transaction;
import com.example.model.TransactionType;


@Service
public class TxrServiceImpl implements TxrService{

	@Autowired
	private AccountRepository accountRepository; 
	
	@Autowired
	private TxnRepository txnRepository;
	
	
	@Override
	@Transactional(rollbackFor = RuntimeException.class)
	public boolean transfer(double amount, String fromAccountNum, String toAccountNum) {
		
		
		Account fromAccount = accountRepository.findById(fromAccountNum).get();
		Account toAccount = accountRepository.findById(toAccountNum).get();
		
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		toAccount.setBalance(toAccount.getBalance()+amount);
		
		accountRepository.save(toAccount);
		accountRepository.save(fromAccount);
		
		
		Transaction transaction = new Transaction();
		transaction.setAccount(toAccount);
		transaction.setAmount(amount);
		transaction.setClosingBalance(toAccount.getBalance());
		transaction.setType(TransactionType.CREDIT);
		transaction.setDateTime(LocalDateTime.now());
		
		txnRepository.save(transaction);
		
		Transaction transaction2 = new Transaction();
		transaction2.setAccount(fromAccount);
		transaction2.setAmount(amount);
		transaction2.setClosingBalance(fromAccount.getBalance());
		transaction2.setType(TransactionType.DEBIT);
		transaction2.setDateTime(LocalDateTime.now());
		
		txnRepository.save(transaction2);
		
		return true;
	}

}
