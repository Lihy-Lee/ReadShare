package com.readshare.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 评论类
 * 
 * @author LHY
 *
 */
public class Comment {
	// 评论id
	private Integer comId;
	// 评论用户
	private Integer userId;
	// 被评论书本
	private Integer bookId;
	// 评论的内容
	private String mark;
	// 评论的创建时间
	private Date createTime;
	// 评论被点赞
	private int support;

	private Book book;
	// 评论被留言队列
	private List<Message> reply;

	public Comment() {
		super();
	}

	public Comment(Integer comId) {
		super();
		this.comId = comId;
	}

	public Comment(Integer userId, Integer book, String mark, Date createTime, int support, List<Message> msg) {
		super();
		this.userId = userId;
		this.bookId = book;

		this.mark = mark;
		this.createTime = createTime;
		this.support = support;
		this.reply = msg;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getSupport() {
		return support;
	}

	public void setSupport(int support) {
		this.support = support;
	}

	public List<Message> getReply() {
		return reply;
	}

	public void setReply(List<Message> reply) {
		this.reply = reply;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String time = format.format(createTime);//将创建时间转换格式
		return "comment [comId=" + comId + ", userId=" + userId + ", bookId=" + bookId + ", mark=" + mark
				+ ", createTime=" + time + ", support=" + support + ", reply=" + reply + "]";
	}

}
