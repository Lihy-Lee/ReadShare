package com.readshare.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readshare.BaseTest;
import com.readshare.entity.User;

public class UserDaoTest extends BaseTest {
	@Autowired
	private UserDao userDao;


	public void testInsertUser() {
		User user = new User();
		user.setUserName("abc");
		user.setUserMobile("3243646");
		user.setPassword("123456");
		user.setIcon("test");
		user.setSex("女");

		System.out.println(userDao.insertUser(user));
		System.out.println(user.getUserId());
	}

	public void testUpdateUser() {
		User user = new User();
		user.setUserId(2);
		user.setPassword("22222");
		userDao.updateUserInfo(user);
	}

	public void testQueryUser() {
		List<User> userList = userDao.queryUserByName("st");
		assertEquals(2, userList.size());
	}

	public void testDeleteUser() {
		userDao.deleteUser(1);
	}
}
