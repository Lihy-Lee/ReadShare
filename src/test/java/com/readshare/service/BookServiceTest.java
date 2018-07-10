package com.readshare.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readshare.BaseTest;
import com.readshare.entity.Book;

public class BookServiceTest extends BaseTest {
	@Autowired
	private BookService bookService;

	public void testGetBookList() {
		List<Book> bookList = bookService.getBookList();
		assertEquals(1, bookList.size());
	}

	public void testGetBookListByName() {
		List<Book> bookList = bookService.getBookListByName("之下");
		System.out.println(bookList);
	}

	public void testAddBook() {
		Book book = new Book(12138, "红高粱", "c:system.test");
		bookService.addBook(book);
	}

	public void testUpdateBook() {
		Book book = new Book(12138, "红高粱", "c://system.test");
		bookService.updateBook(book);
	}

	
	public void testQueryBookById() {
		System.out.println(bookService.getBookById(112));
	}
}
