package com.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.app.db.SQLConnectionFactory;
import com.app.model.Book;
import com.app.model.Chapter;

public class JdbcLibraryRepository implements LibraryRepository{

	@Override
	public List<Book> findBooksByAuthorName(String authorName) {
		Connection connection = null;
		List<Book> books = new ArrayList<>();
		
		
		try {
			connection = SQLConnectionFactory.getConnection();
			String sql = "select * from hr.book b join hr.publishers p on b.publisher_id = p.id where p.name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, authorName);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setIsbnNumber(rs.getInt("isbn"));
				book.setPrice(rs.getDouble("price"));
				book.setPublisherId(rs.getInt("publisher_id"));
				book.setTitle(rs.getString("title"));
				books.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return books;
	}

	@Override
	public List<Chapter> findChaptersByBookTitle(String bookTitle) {
		// TODO Auto-generated method stub
		return null;
	}
		

}
