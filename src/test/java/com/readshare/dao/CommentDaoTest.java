package com.readshare.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.readshare.BaseTest;
import com.readshare.entity.Book;
import com.readshare.entity.Comment;
import com.readshare.entity.User;

public class CommentDaoTest extends BaseTest {
	@Autowired
	private CommentDao comDao;

	public void testInsertCom() {
		Comment com = new Comment();
		User user = new User();
		user.setUserId(2);
		Book book = new Book();
		book.setBookId(112);

		com.setMark("评论test");
		com.setCreateTime(new Date());
		comDao.insertComment(com);
	}

	public void testDeleteCom() {

		comDao.deleteComment(2);
	}

	public void testUpdateComment() {
		Comment comment = new Comment(2);
		comment.setSupport(2);
		comDao.updateComment(comment);
	}


	public void testQueryComment() {
		//sUser user = new User(1);
		//List<Comment> comList = comDao.queryCommentByUserId(1);
		// assertEquals(2, comList.size());

	}
}
