package com.readshare.service;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.readshare.BaseTest;
import com.readshare.entity.Book;
import com.readshare.entity.Comment;

public class CommentServiceTest extends BaseTest {
	@Autowired
	private CommentService comService;

	public void testAddComment() {

		Comment comment = new Comment();
		comment.setBook(new Book(12138));
		comment.setUserId(2);
		comment.setCreateTime(new Date());
		comment.setMark("commentService Test");
		comService.addComment(comment);
	}

	public void testUpdateComment() {

		Comment comment = new Comment(12);
		comment.setSupport(1);
		comService.updateComment(comment);
	}

	public void testDeleteComment() {
		comService.deleteComment(13);
	}

	@Test
	public void testQueryComByserId() {
		System.out.println(comService.queryCommentByUserId(3));
	}

}
