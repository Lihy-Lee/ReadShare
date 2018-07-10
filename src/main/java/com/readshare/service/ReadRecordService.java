package com.readshare.service;

import java.util.List;

import com.readshare.entity.Book;
import com.readshare.entity.ReadRecord;

public interface ReadRecordService {
	/**
	 * 在用户的阅读记录里面添加新的记录
	 * 
	 * @param rr
	 * @return
	 */
	int insertRR(ReadRecord rr);

	/**
	 * 删除读书记录
	 * 
	 * @param rr
	 * @return
	 */
	int deleteRR(ReadRecord rr);

	/**
	 * 根据用户id查找该用户的所有读书记录
	 * 
	 * @param userId
	 * @return
	 */
	List<Book> queryRR(Integer userId);

}
