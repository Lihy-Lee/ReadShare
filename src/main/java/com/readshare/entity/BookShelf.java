package com.readshare.entity;

import java.util.List;

/**
 * 用户书架
 * 
 * @author LHY
 *
 */
public class BookShelf {
	// 书架的所属的用户
	private User user;
	// 书架上的书本
	private Book book;
	
	// 书架上的全部书本列表
	private List<Book> bookList;

	public BookShelf() {
		super();
	}

	public BookShelf(User user) {
		super();
		this.user = user;
	}

	public BookShelf(User user, Book book) {
		super();
		this.user = user;
		this.book = book;
	}

	public BookShelf(User user, List<Book> bookList) {
		super();
		this.user = user;
		this.bookList = bookList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "BookShelf [book=" + book + "]";
	}

}
