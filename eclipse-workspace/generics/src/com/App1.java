package com;

import java.util.Arrays;
import java.util.List;

public class App1 {
	public static void main(String[] args) {
		
		List<Product> products = Arrays.asList(
				
				new Product(12318,"item-1",1000.0),
				new Product(12318,"item-2",7000.0),
				new Product(12318,"item-3",3000.0),
				new Product(12318,"item-4",2000.0),
				new Product(12318,"item-5",5000.0),
				new Product(12318,"item-6",6000.0),
				new Product(12318,"item-7",4000.0),
				new Product(12318,"item-8",9000.0)
			);	

		List<Product> pd = Stream.filter(products,e->e.getPrice()<5000.0);
		List<String> ms = Stream.map(pd,e->e.getName());
		
		Stream.forEach(ms, System.out::println);
		
		
				
	}


}
