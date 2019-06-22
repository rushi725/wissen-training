package com.app.model;

public class Chapter {
	private int index;
	private String title;
	private int pages;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getBook_ISBN() {
		return book_ISBN;
	}
	public void setBook_ISBN(int book_ISBN) {
		this.book_ISBN = book_ISBN;
	}
	private int book_ISBN;

}
