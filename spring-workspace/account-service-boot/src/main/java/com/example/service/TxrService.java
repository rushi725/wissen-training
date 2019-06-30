package com.example.service;

public interface TxrService {
	
	boolean transfer(double amount, String fromAccount, String toAccount);

}
