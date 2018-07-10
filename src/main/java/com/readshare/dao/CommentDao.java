package com.readshare.dao;

import java.util.List;

import com.readshare.entity.Comment;
import com.readshare.entity.Message;

public interface CommentDao {
	/**
	 * 创建新的评论
	 * 
	 * @param comment
	 * @return
	 */
	int insertComment(Comment comment);

	/**
	 * 删除评论
	 * 
	 * @param id
	 */
	int deleteComment(Integer comId);

	/**
	 * 更新评论的内容，如评论获赞个数
	 * 
	 * @param comment
	 */
	int updateComment(Comment comment);

	/**
	 * 根据用户ID
	 * 
	 * @param userId
	 * @return 评论队列
	 */
	List<Comment> queryCommentByUserId(Integer userId);

	/**
	 * 根据评论名字查询该条用户的所有留言信息
	 * 
	 * @param comId
	 * @return
	 */
	List<Message> queryMsgByComId(Integer comId);

	/**
	 * 根据评论名字查询该条用户的所有留言信息
	 * 
	 * @param comId
	 * @return
	 */
	List<Comment> queryCommentByBookId(Integer bookId);
}
