package com;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//interface Lib{
//	public <E> List<E> filter(List<E> list,Predicate<E> condition);
//	public <E,R> List<R> map(List<E> list,Function<E,R> condition);
//	
//}

public class Stream {
		
	public static <E> List<E> filter(List<E> list,Predicate<E> condition){
		List<E> ls = new ArrayList<>();
		for(E products : list) {
			if(condition.test(products)) {
				ls.add(products);
			}
		}
		
		
		return ls;
	}
	
	
	public static<E,R> List<R> map(List<E> list,Function<E,R> condition){
		List<R> ls = new ArrayList<>();
		for(E products : list) {
				ls.add(condition.apply(products));
		}
		return ls;
	}
	
	public static <E> void forEach(List<E> list, Consumer<E> condition){
		for(E ls: list) {
			condition.accept(ls);
		}
	}
	
}
