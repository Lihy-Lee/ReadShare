package com.readshare.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.readshare.BaseTest;
import com.readshare.entity.User;

public class UserServiceTest extends BaseTest {
	@Autowired
	private UserService userService;

	public void testAddUser() {
		User user = new User("HY", "女", "e://codeFile", "06682388352", "123456");
		userService.addUser(user);
	}

	public void testUpdateUserInfo() {
		User user = new User(4);
		userService.updateUserInfo(user);
	}

	public void testQueryUser() {
		List<User> userList = userService.queryUser("st");
		System.out.println(userList);
	}

	public void testDeleteUser() {
		System.out.println(userService.deleteUser(4));
	}

	public void testQueryUserByMobile() {
		System.out.println(userService.queryUserByMobile("111"));
	}

	@Test
	public void testQueryUserById() {
		User user = userService.queryUserById(3);
		System.out.println(user);
	}
}
