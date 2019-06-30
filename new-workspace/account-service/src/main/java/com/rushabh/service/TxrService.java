package com.rushabh.service;
import java.util.List;

import com.rushabh.model.Transaction;

public interface TxrService {

	boolean transfer(double amount, String fromAccNum, String toAccNum);
	
	List<Transaction> getTxrList(String accountNum);

}