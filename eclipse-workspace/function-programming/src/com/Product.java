package com;
import java.util.*;


interface I{
	public boolean test(String s);
}


public class Product {
	
	static List<String> menu = new ArrayList<>();

	 public static void main(String[] args) {
		menu.add("nveg");
		menu.add("veg");
		menu.add("nveg");
		menu.add("veg");
		menu.add("nveg");
		menu.add("nveg");
		
		List<String> veg = getProducts("veg");
		System.err.println(veg.toString());
	 	}
	 
		public static List<String> getProducts(String s) {
			return filter(t -> t.equals(s));
		}
		
		 public static List<String> filter(I cond) {
			List<String> ls = new ArrayList<>();
			for(int i=0;i<menu.size();i++) {
				if(cond.test(menu.get(i))) {
					ls.add(menu.get(i));
				}
			}
			return ls;
		}
}

