package com.app.model;

public class Book {
	
	private int isbnNumber;
	private String title;
	private double price;
	private int publisherId;
	public int getIsbnNumber() {
		return isbnNumber;
	}
	public void setIsbnNumber(int isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	@Override
	public String toString() {
		return "Book [isbnNumber=" + isbnNumber + ", title=" + title + ", price=" + price + ", publisherId="
				+ publisherId + "]";
	}
	
	

}
