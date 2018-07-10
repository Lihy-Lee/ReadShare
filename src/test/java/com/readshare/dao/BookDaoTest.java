package com.readshare.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readshare.BaseTest;
import com.readshare.entity.Book;


public class BookDaoTest extends BaseTest {

	@Autowired
	private BookDao bookDao;

	public void testQueryBook() {
		List<Book> bookList = bookDao.queryBook();
		assertEquals(1, bookList.size());
		// System.out.println(bookList);
	}

	public void testQueryBooksByName() {
		//List<Book> bookList = bookDao.queryBooksByName("下");
		// System.out.println(bookList.get(0).toString());

	}

	public void testInsertBook() {
		Book book = new Book();
		book.setBookId(121);
		book.setBookName("解忧杂货店");
		book.setPhotoUrl("E://");
		bookDao.insertBook(book);
	}


	public void testUpdateBook() {
		Book book = new Book();
		book.setBookId(112);
		book.setPhotoUrl("e://");
		bookDao.updateBook(book);
	}

}
