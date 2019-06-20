package com;

import java.util.ArrayList;
import java.util.List;

public class Factory {
	static Object lock = new Object();
	static int count=0;
	static List<Integer> list = new ArrayList<>();
	
	static class EvenFactory{
		public  void evenFactory() {
				while(count<=100) {
					synchronized (lock) {
					System.out.println("Boy Turn "+ count);
					list.add(count);
					count++;
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					lock.notify();
					try {
						lock.wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
					if(count == 101) {
						lock.notify();
					}
				}
			}
				//lock.notify();
			}
	}
	static class OddFactory{
		public synchronized void oddFactory() {
			while(count<=100) {
				synchronized (lock) {
				System.out.println("Girl Turn " + count);
				list.add(count);
				count++;
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lock.notify();
				try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if(count == 101) {
					lock.notify();
				}
			}
			}
			//lock.notify();
		}
	}
	public static void main(String[] args) {
		OddFactory f2 = new OddFactory();
		EvenFactory f1 = new EvenFactory();
		
		Thread t1 = new Thread(()->f1.evenFactory());
		Thread t2 = new Thread(()->f2.oddFactory());

		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
	}

}
