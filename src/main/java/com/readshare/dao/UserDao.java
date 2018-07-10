package com.readshare.dao;

import java.util.List;

import com.readshare.entity.User;

public interface UserDao {

	/**
	 * 新建用户，用户注册
	 * 
	 * @param user
	 * @return 1表示成功插入信息，返回-1表示新增失败
	 */
	int insertUser(User user);

	/**
	 * 更新用户个人信息
	 * 
	 * @param user
	 * @return
	 */
	int updateUserInfo(User user);

	/**
	 * 根据用户名模糊查找用户
	 * 
	 * @param userName
	 * @return
	 */
	List<User> queryUserByName(String userName);

	/**
	 * 根据手机号查询用户
	 * 
	 * @param userMobile
	 * @return
	 */
	User queryUserByMoblie(String userMobile);

	/**
	 * 根据用户id查询用户信息
	 * 
	 * @param userId
	 * @return
	 */
	User queryUserByUserId(Integer userId);

	/**
	 * 删除用户
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
