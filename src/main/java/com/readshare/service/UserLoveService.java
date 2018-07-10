package com.readshare.service;

import java.util.List;

import com.readshare.entity.Book;
import com.readshare.entity.UserLove;

public interface UserLoveService {
	/**
	 * 增加收藏记录
	 * 
	 * @param userlove
	 * @return
	 */
	int insertUserLove(UserLove userlove);

	/**
	 * 删除收藏记录
	 * 
	 * @param userlove
	 * @return
	 */
	int deleteUserLove(UserLove userlove);

	/**
	 * 根据用户的id查询用户的所有收藏列表
	 * 
	 * @param userId
	 * @return
	 */
	List<Book> queryUserLoveByUserId(Integer userId);

}
