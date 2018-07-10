package com.readshare.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.readshare.BaseTest;
import com.readshare.entity.Book;
import com.readshare.entity.BookShelf;
import com.readshare.entity.User;

public class BookShelfServiceTest extends BaseTest {
	@Autowired
	private BookShelfService bsService;

	public void testAddBSService() {
		BookShelf bookshelf = new BookShelf();
		bookshelf.setBook(new Book(11));
		bookshelf.setUser(new User(2));
		bsService.addBookToBookShelf(bookshelf);
	}

	public void testQueryBSService() {
		System.out.println(bsService.queryBookFromBookShelf(3));
	}

	public void testDeleteBSService() {
		BookShelf bookshelf = new BookShelf();
		bookshelf.setBook(new Book(11));
		bookshelf.setUser(new User(2));
		bsService.deleteBookFromBookShelf(bookshelf);
	}

	@Test
	public void testQueryByUserId() {
		System.out.println(bsService.queryBookFromBookShelf(3));
	}
}
