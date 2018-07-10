package com.readshare.entity;

public class UserLove {
	private User user;
	private Book book;

	public UserLove() {
		super();
	}

	public UserLove(User user, Book book) {
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

	@Override
	public String toString() {
		return "UserLove [user=" + user + ", book=" + book + "]";
	}

}
