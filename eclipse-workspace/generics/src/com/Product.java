package com;

public class Product {

	public Product(int id, String name, double d) {
		super();
		this.id = id;
		this.name = name;
		this.price = d;
	}
	private int id;
	private String name;
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
