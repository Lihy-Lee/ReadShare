package com.readshare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readshare.dao.BookDao;
import com.readshare.dao.BookShelfDao;
import com.readshare.entity.Book;
import com.readshare.entity.BookShelf;
import com.readshare.service.BookShelfService;

@Service
public class BookShelfServiceImpl implements BookShelfService {
	@Autowired
	private BookShelfDao bookShelfDao;

	@Autowired
	private BookDao bookDao;

	@Override
	public int addBookToBookShelf(BookShelf bookshelf) {
		int bookId = bookshelf.getBook().getBookId();
		// 查询数据库中是不是已经存在书本
		Book book = bookDao.queryBookById(bookId);
		if (book == null) {// 书本不存在
			// 将书本信息存放到数据库中
			bookDao.insertBook(bookshelf.getBook());
		}

		return bookShelfDao.insertBookShelf(bookshelf);
	}

	@Override
	public int deleteBookFromBookShelf(BookShelf bookshelf) {

		return bookShelfDao.deleteBookShelf(bookshelf);
	}

	@Override
	public List<Book> queryBookFromBookShelf(Integer userId) {
		return bookShelfDao.queryBookShelf(userId);
	}

}
