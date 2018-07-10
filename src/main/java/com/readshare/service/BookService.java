package com.readshare.service;

import java.util.List;

import com.readshare.entity.Book;
import com.readshare.entity.Comment;

public interface BookService {
	/**
	 * 查询所有的书本，获取书本队列
	 * 
	 * @return
	 */
	List<Book> getBookList();

	/**
	 * 根据书本名字查询书本，获取书本队列
	 * 
	 * @param bookName
	 * @return
	 */
	List<Book> getBookListByName(String bookName);

	/**
	 * 根据书本Id查询书本,获取书本基本信息以及所有评论信息
	 * 
	 * @param bookId
	 * @return
	 */
	Book getBookById(Integer bookId);

	/**
	 * 增加书本信息
	 * 
	 * @param book
	 * @return
	 */
	int addBook(Book book);

	/**
	 * 更新书本信息
	 * 
	 * @param book
	 */
	void updateBook(Book book);

	/**
	 * 根据书本id查看该书本的所有评论
	 * 
	 * @param bookId
	 * @return
	 */
	List<Comment> queryBookComment(Integer bookId);

	/**
	 * 根据书本id查询该书本在数据库中是否存在
	 * @param bookId
	 * @return
	 */
	Book queryBookById(Integer bookId);

}
