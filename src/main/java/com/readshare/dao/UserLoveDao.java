package com.readshare.dao;

import java.util.List;

import com.readshare.entity.Book;
import com.readshare.entity.UserLove;

public interface UserLoveDao {
	/**
	 * 增加收藏的书本
	 * 
	 * @param userLove
	 * @return
	 */
	int insertUserLove(UserLove userLove);

	/**
	 * 从用户收藏列表中除移书本
	 * 
	 * @param userLove
	 * @return
	 */
	int deleteUserLove(UserLove userLove);

	/**
	 * 根据用户id查询用户的收藏列表
	 * 
	 * @param userId
	 * @return
	 */
	List<Book> queryUserLoveByUserId(Integer userId);

}
