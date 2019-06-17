package com.atm;

import java.util.*;

interface  Chain{
	void setNext(Chain nextInChain);
	void processRequest(int amount, HashMap<Integer,Integer> map);
}



class Currency_Hundred implements Chain{
	private Chain next;
	private int count;
	public static final int CURRENCY = 100;
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return this.count;
	}
	@Override
	public void setNext(Chain nextInChain) {
		next = nextInChain;
		
	}

	@Override
	public void processRequest(int amount, HashMap<Integer,Integer> map) {
		if(amount < Currency_Hundred.CURRENCY || count<=0) {
			next.processRequest(amount,map);
		}
		else {
			int c = amount/Currency_Hundred.CURRENCY;
			int x = Math.min(c,count);
			this.count -= x;
			amount -= Currency_Hundred.CURRENCY*x;
			int old=0;
			if(map.get(Currency_Hundred.CURRENCY)!=null)
				old = map.get(Currency_Hundred.CURRENCY);
			map.put(Currency_Hundred.CURRENCY,old+x);
			if(amount == 0) {
				System.out.println(map.toString());
			}
			else {
				next.processRequest(amount, map);
			}
		}
		
	}
	
}

class Currency_Five_Hundred implements Chain{
	private Chain next;
	private int count;
	public static final int CURRENCY = 500;
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return this.count;
	}
	@Override
	public void setNext(Chain nextInChain) {
		next = nextInChain;
		
	}

	@Override
	public void processRequest(int amount, HashMap<Integer,Integer> map) {
		if(amount < Currency_Five_Hundred.CURRENCY || count<=0) {
			next.processRequest(amount,map);
		}
		else {
			int c = amount/Currency_Five_Hundred.CURRENCY;
			int x = Math.min(c,count);
			this.count -= x;
			amount -= Currency_Five_Hundred.CURRENCY*x;
			int old=0;
			if(map.get(Currency_Five_Hundred.CURRENCY)!=null)
				old = map.get(Currency_Five_Hundred.CURRENCY);
			map.put(Currency_Five_Hundred.CURRENCY,old+x);
			if(amount == 0) {
				System.out.println(map.toString());
			}
			else {
				next.processRequest(amount, map);
			}
		}
		
	}
	
}



class Currency_Thousand implements Chain{
	private Chain next;
	private int count;
	public static final int CURRENCY = 1000;
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return this.count;
	}
	@Override
	public void setNext(Chain nextInChain) {
		next = nextInChain;
		
	}

	@Override
	public void processRequest(int amount, HashMap<Integer,Integer> map) {
		if(amount < Currency_Thousand.CURRENCY || count<=0) {
			next.processRequest(amount,map);
		}
		else {
			int c = amount/Currency_Thousand.CURRENCY;
			int x = Math.min(c,count);
			this.count -= x;
			amount -= Currency_Thousand.CURRENCY*x;
			int old=0;
			if(map.get(Currency_Thousand.CURRENCY)!=null)
				old = map.get(Currency_Thousand.CURRENCY);
			map.put(Currency_Thousand.CURRENCY,old+x);
			if(amount == 0) {
				System.out.println(map.toString());
			}
			else {
				next.processRequest(amount, map);
			}
		}
		
	}
	
}

public class ATM {
	
	public static void main(String[] args) {
		Currency_Hundred c1 = new Currency_Hundred();
		Currency_Five_Hundred c2 = new Currency_Five_Hundred();
		Currency_Thousand c3 = new Currency_Thousand();
		
		c3.setNext(c2);
		c2.setNext(c1);
		
		c1.setCount(3);
		c2.setCount(4);
		c3.setCount(3);
		
		HashMap<Integer,Integer> map = new  HashMap<Integer,Integer>();
		c3.processRequest(5300, map);
		
	}
}
