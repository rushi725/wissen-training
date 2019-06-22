package com.app.repository;

import java.util.List;

import com.app.model.Author;
import com.app.model.Book;
import com.app.model.Chapter;

public interface LibraryRepository {
	
	public List<Book> findBooksByAuthorName(String authorName);
	public List<Chapter> findChaptersByBookTitle(String bookTitle);
}
