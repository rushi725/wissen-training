package com.app.emp;

public class Employee {
	public final static String COMP_NAME="Wissen";
	public static String tnrName;
	
	public int id;
	public String name;
	
	public Employee() {
		
	}

	
	public static void teach() {
		System.out.println("Employee::teach()");
	}
	
	public void listenAndWork() {
		System.out.println(this.name+"listens");
	}
}
