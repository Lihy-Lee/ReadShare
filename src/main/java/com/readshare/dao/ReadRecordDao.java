package com.readshare.dao;

import java.util.List;

import com.readshare.entity.Book;
import com.readshare.entity.ReadRecord;

public interface ReadRecordDao {
	/**
	 * 增加读书记录
	 * 
	 * @param readRecord
	 * @return
	 */
	int insertReadRecord(ReadRecord readRecord);

	/**
	 * 删除读书记录
	 * 
	 * @param readRecord
	 */
	int deleteReadRecord(ReadRecord readRecord);

	/**
	 * 根据用户的id查找该用户的已读书本记录
	 * 
	 * @param userId
	 * @return
	 */
	List<Book> queryReadRecord(Integer userId);

}
