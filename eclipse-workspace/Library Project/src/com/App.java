package com;

import java.util.List;

import com.app.db.SQLConnectionFactory;
import com.app.model.Book;
import com.app.repository.JdbcLibraryRepository;
import com.app.repository.LibraryRepository;

public class App {

	public static void main(String[] args) {
		LibraryRepository lr = new JdbcLibraryRepository();
		
		List<Book> books = lr.findBooksByAuthorName("JK Rowling");
		
		books.forEach(System.out::println);
		System.out.println(books);
		

	}

}
