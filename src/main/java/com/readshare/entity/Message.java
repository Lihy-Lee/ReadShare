package com.readshare.entity;

import java.util.Date;

/**
 * 留言对象类
 * 
 * @author LHY
 *
 */
public class Message {
	// 留言id
	private Integer replyId;
	// 留言的内容
	private String mark;
	// 留言时间
	private Date createTime;
	// 留言被点赞个数
	private int support;
	// 被留言的评论id
	private Integer comId;
	// 留言被回复的内容
	private String beReply;
	// 留言用户
	private Integer userId;
	// 留言用户的名字
	private String username;

	public Message() {
		super();
	}

	public Message(String content, Date createTime, int support) {
		super();
		this.mark = content;
		this.createTime = createTime;
		this.support = support;
	}

	public Message(String content, Date createTime, int support, Integer comment, String mark, Integer user) {
		super();
		this.mark = content;
		this.createTime = createTime;
		this.support = support;
		this.comId = comment;
		this.beReply = mark;
		this.userId = user;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
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

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public String getBeReply() {
		return beReply;
	}

	public void setBeReply(String beReply) {
		this.beReply = beReply;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Message [replyId=" + replyId + ", mark=" + mark + ", createTime=" + createTime + ", comId=" + comId
				+ ", beReply=" + beReply + ", username=" + username + "]";
	}

}
