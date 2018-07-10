package com.readshare.service;

import java.util.List;

import com.readshare.entity.Comment;
import com.readshare.entity.Message;

public interface CommentService {
	/**
	 * 新建评论
	 * 
	 * @param comment
	 * @return
	 */
	int addComment(Comment comment);

	/**
	 * 根据评论ID删除评论
	 * 
	 * @param comId
	 * @return
	 */
	int deleteComment(Integer comId);

	/**
	 * 更新评论基本信息，如获赞个数，以及回复
	 * 
	 * @param comment
	 * @return
	 */
	int updateComment(Comment comment);


	/**
	 * 根据书本id，查询该书本的所有评论
	 * 
	 * @param bookId
	 * @return
	 */
	List<Comment> queryCommentByBookId(Integer bookId);

	/**
	 * 根据评论名字查询该条用户的所有留言信息
	 * 
	 * @param comId
	 * @return
	 */
	List<Message> queryMsgByComId(Integer comId);

	/**
	 * 根据用户id查找评论
	 * 
	 * @param userId
	 * @return
	 */
	List<Comment> queryCommentByUserId(Integer userId);
}
