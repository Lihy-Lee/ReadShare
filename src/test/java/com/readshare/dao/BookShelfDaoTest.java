package com.readshare.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readshare.BaseTest;
import com.readshare.entity.Book;
import com.readshare.entity.BookShelf;
import com.readshare.entity.User;

public class BookShelfDaoTest extends BaseTest {
	@Autowired
	private BookShelfDao bookshelfDao;

	public void testInsertBook() {
		User user = new User();
		user.setUserId(1);
		Book book = new Book();
		book.setBookId(11);
		BookShelf bookshelf = new BookShelf(user, book);
		bookshelfDao.insertBookShelf(bookshelf);
	}

	public void testQueryBookShelf() {

		List<Book> bookList = bookshelfDao.queryBookShelf(1);
		System.out.println(bookList);
	}

	
	public void testDeleteBookShelf() {
		User user = new User();
		user.setUserId(1);
		Book book = new Book();
		book.setBookId(11);
		BookShelf bookshelf = new BookShelf(user, book);
		bookshelfDao.deleteBookShelf(bookshelf);
	}

}
