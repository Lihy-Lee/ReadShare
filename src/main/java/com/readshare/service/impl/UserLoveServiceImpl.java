package com.readshare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readshare.dao.BookDao;
import com.readshare.dao.UserLoveDao;
import com.readshare.entity.Book;
import com.readshare.entity.UserLove;
import com.readshare.service.UserLoveService;

@Service
public class UserLoveServiceImpl implements UserLoveService {
	@Autowired
	private UserLoveDao userloveDao;
	@Autowired
	private BookDao bookDao;

	@Override
	public int insertUserLove(UserLove userlove) {
		Book book = userlove.getBook();

		Book newBook = bookDao.queryBookById(book.getBookId());
		// 书本在数据库中不存在
		if (newBook == null) {
			bookDao.insertBook(book);
		}

		return userloveDao.insertUserLove(userlove);
	}

	@Override
	public int deleteUserLove(UserLove userlove) {
		return userloveDao.deleteUserLove(userlove);
	}

	@Override
	public List<Book> queryUserLoveByUserId(Integer userId) {
		return userloveDao.queryUserLoveByUserId(userId);
	}

}
