package com.readshare.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.readshare.BaseTest;
import com.readshare.entity.Book;
import com.readshare.entity.User;
import com.readshare.entity.UserLove;

public class UserLoveServiceTest extends BaseTest {
	@Autowired
	private UserLoveService userLoveService;

	public void testInsertUserLove() {
		UserLove userlove = new UserLove(new User(2), new Book(11));
		userLoveService.insertUserLove(userlove);
	}

	public void testDeleteUserLove() {
		UserLove userlove = new UserLove(new User(2), new Book(11));
		userLoveService.deleteUserLove(userlove);
	}

	public void testQueryUserLoveById() {
		System.out.println(userLoveService.queryUserLoveByUserId(3));
	}
}
