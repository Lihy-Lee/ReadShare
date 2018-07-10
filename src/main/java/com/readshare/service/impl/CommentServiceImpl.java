package com.readshare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readshare.dao.BookDao;
import com.readshare.dao.CommentDao;
import com.readshare.dao.MessageDao;
import com.readshare.entity.Book;
import com.readshare.entity.Comment;
import com.readshare.entity.Message;
import com.readshare.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao comDao;
	@Autowired
	private MessageDao msgDao;

	@Autowired
	private BookDao bookDao;

	@Override
	public int addComment(Comment comment) {

		return comDao.insertComment(comment);
	}

	@Override
	public int deleteComment(Integer comId) {
		return comDao.deleteComment(comId);
	}

	@Override
	public int updateComment(Comment comment) {
		return comDao.updateComment(comment);
	}

	@Override
	public List<Message> queryMsgByComId(Integer comId) {
		List<Message> msgList = msgDao.queryMsgList(comId);

		return msgList;
	}

	@Override
	public List<Comment> queryCommentByBookId(Integer bookId) {
		List<Comment> comList = comDao.queryCommentByBookId(bookId);
		for (int i = 0; i < comList.size(); i++) {
			int comId = comList.get(i).getComId();
			//根据评论id查询评论留言列表
			List<Message> replyList = msgDao.queryMsgList(comId);
			comList.get(i).setReply(replyList);
		}
		return comList;

	}

	@Override
	public List<Comment> queryCommentByUserId(Integer userId) {
		List<Comment> comList = comDao.queryCommentByUserId(userId);
		for (int i = 0; i < comList.size(); i++) {
			int bookId = comList.get(i).getBookId();
			Book book = bookDao.queryBookById(bookId);
			comList.get(i).setBook(book);
		}
		return comList;
	}

}
