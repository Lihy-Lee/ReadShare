package com.readshare.service;

import java.util.List;

import com.readshare.entity.User;

public interface UserService {
	/**
	 * 增加用户信息
	 * 
	 * @param user
	 * @return
	 */
	int addUser(User user);

	/**
	 * 更新用户个人信息
	 * 
	 * @param user
	 * @return
	 */
	int updateUserInfo(User user);

	/**
	 * 根据用户名模糊查询用户
	 * 
	 * @param userName
	 * @return
	 */
	List<User> queryUser(String userName);

	/**
	 * 根据手机号查询用户是否存在
	 * 
	 * @param userMobile
	 * @return
	 */
	User queryUserByMobile(String userMobile);

	/**
	 * 根据用户id查询用户所有个人信息，包括id,姓名,性别,封面图片url,手机号,密码
	 * 
	 * @param userId
	 * @return
	 */
	User queryUserById(Integer userId);

	/**
	 * 根据用户ID删除用户
	 * 
	 * @param userId
	 */
	int deleteUser(Integer userId);

	/**
	 * 查询数据库中所有的用户
	 * 
	 * @return
	 */
	List<User> queryAllUser();

}
