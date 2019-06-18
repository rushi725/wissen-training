package com;

import java.util.function.Predicate;

public class FP_Principles {
	
	
	public static void main(String[] args) {
		Predicate<Integer> predicate1 = i -> i>50;
		Predicate<Integer> predicate2 = i -> i<100;
		
		Predicate<Integer> predicate = and(predicate1,predicate2);
		
		predicate = predicate1.and(predicate2);
		
		boolean val = predicate.test(100);
		System.out.println(val);
	}
	//Hiher Order Function ==> Higher Order Programming
	private static Predicate<Integer> and(Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
		
		return i -> predicate1.test(i) && predicate2.test(i);
	}

}
