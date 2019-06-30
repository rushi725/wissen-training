package com.example.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Transactions")
public class Transaction {
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name = "TDate")
	private LocalDateTime dateTime;
	@Column(name = "Amount")
	private double amount;
	@Column(name = "ClosingBalance")
	private double closingBalance;
	@Column(name = "Type")
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	
	@ManyToOne
	@JoinColumn(name = "AccountNumber")
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
