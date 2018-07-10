package com.readshare.entity;

import java.util.List;

public class ReadRecord {
	// 该读书记录对于的用户
	private User user;
	// 读书记录中的书本
	private Book book;
	// 某用户的所有读书记录
	private List<Book> bookList;

	public ReadRecord() {
		super();
	}

	public ReadRecord(User user, Book book) {
		super();
		this.user = user;
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		return "hadRead [ book=" + book + "]";
	}

}
