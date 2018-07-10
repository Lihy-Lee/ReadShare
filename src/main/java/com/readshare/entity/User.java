package com.readshare.entity;

import java.util.List;

/**
 * 用户对象类
 * 
 * @author LHY
 *
 */
public class User {
	// 用户ID
	private Integer userId;
	// 用户名，昵称
	private String userName;
	// 性别
	private String sex;
	// 用户头像图片链接
	private String icon;
	// 用户手机号
	private String userMobile;
	// 用户密码
	private String password;

	// 用户书架上的书本
	private List<Book> bookshelf;
	// 用户已经读过的书本
	private List<Book> hadRead;
	// 我所有的评论
	private List<Comment> comment;
	// 用户收藏的书本
	private List<Book> loveBooks;

	public User() {
		super();
	}

	public User(Integer userId, String userName, String userMobile, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userMobile = userMobile;
		this.password = password;
	}

	public User(String userName, String sex, String icon, String userMobile, String password) {
		super();
		this.userName = userName;
		this.sex = sex;
		this.icon = icon;
		this.userMobile = userMobile;
		this.password = password;
	}

	public User(Integer userId) {
		super();
		this.userId = userId;
	}

	public User(Integer userId, String userName, String sex) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.sex = sex;
	}

	public User(String userName, String userMobile, String password) {
		super();
		this.userName = userName;
		this.userMobile = userMobile;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Book> getBookshelf() {
		return bookshelf;
	}

	public void setBookshelf(List<Book> bookshelf) {
		this.bookshelf = bookshelf;
	}

	public List<Book> getHadRead() {
		return hadRead;
	}

	public void setHadRead(List<Book> hadRead) {
		this.hadRead = hadRead;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public List<Book> getLoveBooks() {
		return loveBooks;
	}

	public void setLoveBooks(List<Book> loveBooks) {
		this.loveBooks = loveBooks;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", sex=" + sex + ", icon=" + icon + ", userMobile="
				+ userMobile + ", password=" + password + ", bookshelf=" + bookshelf + ", hadRead=" + hadRead
				+ ", comment=" + comment + ", loveBooks=" + loveBooks + "]";
	}

}
