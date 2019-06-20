package com;

import java.util.Scanner;

public class Ex_Thread extends Thread{
	
	public static void main(String[] args) {
		String name = Thread.currentThread().getName();
		System.out.println(name);
		doIO();
		Ex_Thread thread = new Ex_Thread();
		thread.run();
	}
	
	
	
	public static void doComputation() {
		while(true) {
		}
	}
	
	public static void doIO() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name...");
		String name = sc.next();
		System.out.println("Your name is " + name  );
		System.out.println("IO Completed");
		sc.close();
	}



	@Override
	public void run() {
		int i=0;
		while(i <50)
			System.out.println(i++);
	}

}
