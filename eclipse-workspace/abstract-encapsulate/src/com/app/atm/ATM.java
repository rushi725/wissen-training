package com.app.atm;

public class ATM implements Card {

	int total;
	private Card card;
	public ATM(){
		this.total=1000;
	}


	@Override
	public int details() {
		// TODO Auto-generated method stub
		return accountNo;
	}
	public void balance() {

		int no=card.details();
		System.out.println(no+":"+total);
	}
}

