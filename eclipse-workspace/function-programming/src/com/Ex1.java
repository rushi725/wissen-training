package com;

import java.util.function.*;

public class Ex1 {
	
	
	public static void main(String[] args) {
		Function<String,Integer> f1 = s -> Integer.parseInt(s) ;
		//Function<Integer,String> f2 = i -> String.valueOf(i);
		//Higher Order Function ==> Higher Order Programming
		Function<Function<String,Integer>,Function<String,Integer> > inpFunc= i->{
				return s-> {
					System.out.println("Before Log");
					int r = i.apply(s);
					System.out.println("After LOg");
					return r;
				};
		};
		Function<String,Integer> skip = inpFunc.apply(f1);
		int val = skip.apply("123");
		int val2 = f1.apply("123");
		System.out.println(val + "\n" + val2);
	}


}


