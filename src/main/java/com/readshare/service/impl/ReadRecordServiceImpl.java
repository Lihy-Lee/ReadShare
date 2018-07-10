package com.readshare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readshare.dao.BookDao;
import com.readshare.dao.ReadRecordDao;
import com.readshare.entity.Book;
import com.readshare.entity.ReadRecord;
import com.readshare.service.ReadRecordService;

@Service
public class ReadRecordServiceImpl implements ReadRecordService {
	@Autowired
	public ReadRecordDao rrDao;
	
	@Autowired
	private BookDao bookDao;

	@Override
	public int insertRR(ReadRecord rr) {
		//插入阅读记录之前先检查数据库中有没有该书本的基本信息
		int bookId = rr.getBook().getBookId();
		
		Book book = bookDao.queryBookById(bookId);
		//数据库中书本没有，需要插入书本
		if(book ==null) {
			bookDao.insertBook(rr.getBook());
		}
		return rrDao.insertReadRecord(rr);
	}

	@Override
	public int deleteRR(ReadRecord rr) {
		return rrDao.deleteReadRecord(rr);
	}

	@Override
	public List<Book> queryRR(Integer userId) {
		return rrDao.queryReadRecord(userId);
	}

}
