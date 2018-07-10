package com.readshare.dao;

import java.util.List;

import com.readshare.entity.Book;
import com.readshare.entity.Comment;

public interface BookDao {
	/**
	 * 列出书库中所有的书本
	 * 
	 * @return bookList
	 */
	public List<Book> queryBook();;

	/**
	 * 根据书名模糊查找数据库中的书本
	 * 
	 * @param name
	 * @return
	 */
	public List<Book> queryBooksByName(String name);

	/**
	 * 根据书名id查找数据库中的书本
	 * 
	 * @param bookId
	 * @return
	 */
	public Book queryBookById(Integer bookId);

	/**
	 * 在数据库中增加书本信息
	 * 
	 * @param book
	 * @return
	 */
	public int insertBook(Book book);

	/**
	 * 更新书本信息
	 * 
	 * @param book
	 */
	public int updateBook(Book book);

	/**
	 * 根据书本id查看该书本的所有评论
	 * 
	 * @param bookId
	 * @return 评论列表
	 */
	public List<Comment> queryBookComment(Integer bookId);

}
