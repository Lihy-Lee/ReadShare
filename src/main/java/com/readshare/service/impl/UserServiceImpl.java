package com.readshare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readshare.dao.UserDao;
import com.readshare.entity.Book;
import com.readshare.entity.Comment;
import com.readshare.entity.User;
import com.readshare.service.BookShelfService;
import com.readshare.service.CommentService;
import com.readshare.service.ReadRecordService;
import com.readshare.service.UserLoveService;
import com.readshare.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private CommentService comService;// 用户评论列表

	@Autowired
	private BookShelfService bsService;// 书架

	@Autowired
	private ReadRecordService rrService;// 阅读记录

	@Autowired
	private UserLoveService userloveService;// 收藏记录

	@Override
	public int addUser(User user) {
		userDao.insertUser(user);
		return user.getUserId();
	}

	@Override
	public int updateUserInfo(User user) {
		return userDao.updateUserInfo(user);
	}

	@Override
	public List<User> queryUser(String userName) {

		return userDao.queryUserByName(userName);
	}

	@Override
	public int deleteUser(Integer userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public User queryUserByMobile(String userMobile) {
		User user = userDao.queryUserByMoblie(userMobile);

		return user;
	}

	@Override
	public User queryUserById(Integer userId) {
		User user = userDao.queryUserByUserId(userId);
		List<Book> bookshelf = bsService.queryBookFromBookShelf(userId);
		List<Comment> myCom = comService.queryCommentByUserId(userId);
		List<Book> myRead = rrService.queryRR(userId);
		List<Book> myLove = userloveService.queryUserLoveByUserId(userId);
		
		user.setComment(myCom);
		user.setBookshelf(bookshelf);
		user.setHadRead(myRead);
		user.setLoveBooks(myLove);
		return user;
	}

	@Override
	public List<User> queryAllUser() {

		return userDao.queryAllUser();
	}

}
