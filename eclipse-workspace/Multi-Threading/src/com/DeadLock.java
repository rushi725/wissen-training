package com;

 class Mary {
	
	public void methodOne(John j) {
		synchronized(this) {
			System.out.println("Mary : methodOne()");
			j.methodTwo();
		}
	}
	
	public synchronized void methodTwo() {
		synchronized(this) {
			System.out.println("Mary : methodTwo()");
		}
	}
	
}


 class John{
	public synchronized void methodOne(Mary m) {
		synchronized(this) {
			System.out.println("John : methodOne()");
			m.methodTwo();
		}
	}
	
	public synchronized void methodTwo() {
		synchronized(this) {
			System.out.println("John : methodTwo()");
		}
	}
}


public class DeadLock{
	public static void main(String[] args) {
		
		Mary m1 = new Mary();
		John j1 = new John();
		Runnable task1 = ()->{
			m1.methodOne(j1);
											
		};
		Runnable task2 = ()->{
			j1.methodOne(m1);
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		t1.start();
		t2.start();
	}
}