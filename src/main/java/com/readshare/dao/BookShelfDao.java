package com.readshare.dao;

import java.util.List;

import com.readshare.entity.Book;
import com.readshare.entity.BookShelf;

public interface BookShelfDao {
	/**
	 * 在书架上增加书本
	 * 
	 * @param book
	 * @return
	 */
	int insertBookShelf(BookShelf bookshelf);

	/**
	 * 删除用户书架上的书本
	 * 
	 * @param book
	 * @return 
	 */
	int deleteBookShelf(BookShelf bookshelf);

	/**
	 * 根据用户名查找该用户书架上所有的书本
	 * 
	 * @param userId
	 * @return
	 */
	List<Book> queryBookShelf(Integer userId);

}
