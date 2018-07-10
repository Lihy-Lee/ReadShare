package com.readshare.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.readshare.BaseTest;
import com.readshare.entity.Book;
import com.readshare.entity.ReadRecord;
import com.readshare.entity.User;

public class RRServiceTest extends BaseTest {
	@Autowired
	private ReadRecordService rrService;

	public void testInsertRR() {
		ReadRecord rr = new ReadRecord(new User(2), new Book(121));
		rrService.insertRR(rr);
	}
	@Test
	public void testQueryRR() {
		System.out.println(rrService.queryRR(3));
	}

	public void testDeleteRR() {
		ReadRecord rr = new ReadRecord(new User(2), new Book(121));
		rrService.deleteRR(rr);
	}
}
