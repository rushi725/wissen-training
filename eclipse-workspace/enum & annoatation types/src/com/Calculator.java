package com;

public class Calculator {
	
	public int add(int a,int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		Object[] arr = new Object[20];
		arr[0] = new String("1");
		
		System.out.println(arr[0].getClass().toString());
	}

}
