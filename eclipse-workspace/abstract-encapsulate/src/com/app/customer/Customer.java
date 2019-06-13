package com.app.customer;

import com.app.atm.ATM;

public class Customer {
	String name;
	
	public Customer() {
		name="Amit";
	}
	
	void checkTotal() {
		ATM a1=new ATM();
		a1.balance();
	}
	
}
