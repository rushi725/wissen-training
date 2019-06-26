package com.rushabh.model;

import java.time.LocalDateTime;

public class Transaction {
	
	private int id;
	private LocalDateTime dateTime;
	private double amount;
	private double closingBalance;
	private TransactionType type;
	private Account account;
	

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public double getAmount() {
		return amount;
	}
	public TransactionType getType() {
		return type;
	}

	public double getClosingBalance() {
		return closingBalance;
	} 

}
