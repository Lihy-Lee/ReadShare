package com.readshare.service;

import java.util.List;

import com.readshare.entity.Book;
import com.readshare.entity.BookShelf;
/**
 * 书架
 * @author LHY
 *
 */
public interface BookShelfService {
	/**
	 * 往书架上添加新的数本年
	 * 
	 * @param bookShelf
	 * @return
	 */
	int addBookToBookShelf(BookShelf bookShelf);

	/**
	 * 从书架上删除书本
	 * 
	 * @param bookShelf
	 * @return
	 */
	int deleteBookFromBookShelf(BookShelf bookShelf);

	/**
	 * 根据用户ID，查找某用户的书架上的所有书本
	 * 
	 * @param bookShelf
	 * @return 书本队列
	 */
	List<Book> queryBookFromBookShelf(Integer userId);

}
