package com.readshare.entity;

import java.util.List;

/**
 * 书本类
 * 
 * @author LHY
 *
 */
public class Book {
	// 书本id
	private Integer bookId;
	// 书本名字
	private String bookName;
	// 书本封面对应的url
	private String photoUrl;
	// 该书本对应的所有评论
	private List<Comment> bookCom;

	public Book() {
		super();
	}

	public Book(Integer bookId) {
		super();
		this.bookId = bookId;
	}

	public Book(String bookName, String photoUrl) {
		super();
		this.bookName = bookName;
		this.photoUrl = photoUrl;
	}

	public Book(Integer bookId, String bookName, String photoUrl) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.photoUrl = photoUrl;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public List<Comment> getBookCom() {
		return bookCom;
	}

	public void setBookCom(List<Comment> bookCom) {
		this.bookCom = bookCom;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", photoUrl=" + photoUrl + ", bookCom=" + bookCom
				+ "]";
	}

}
