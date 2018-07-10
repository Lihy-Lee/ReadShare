package com.readshare.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readshare.BaseTest;
import com.readshare.entity.Book;
import com.readshare.entity.ReadRecord;
import com.readshare.entity.User;

public class ReadRecordDaoTest extends BaseTest {

	@Autowired
	private ReadRecordDao rrDao;

	public void testInsertRR() {
		User user = new User(1);
		Book book = new Book(11);
		ReadRecord rr = new ReadRecord(user, book);
		rrDao.insertReadRecord(rr);
	}

	public void testDeleteRR() {
		User user = new User(1);
		Book book = new Book(11);
		ReadRecord rr = new ReadRecord(user, book);
		rrDao.deleteReadRecord(rr);
	}


	public void testQueryRR() {
		List<Book> bookList = rrDao.queryReadRecord(1);
		System.out.println(bookList);

	}
}
