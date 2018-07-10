package com.readshare.service;

import java.util.List;

import com.readshare.entity.Message;

public interface MessageService {
	/**
	 * 新增加留言信息
	 * 
	 * @param msg
	 * @return
	 */
	int insertMsg(Message msg);

	/**
	 * 删除留言信息
	 * 
	 * @param msg
	 * @return
	 */
	int deleteMsg(Integer msgId);

	/**
	 * 更新留言信息，获赞个数以及被回复的内容
	 * 
	 * @param msg
	 * @return
	 */
	int updateMsg(Message msg);

	/**
	 * 根据评论ID查询该评论下所有的留言
	 * 
	 * @param comId
	 * @return
	 */
	List<Message> queryMsgList(Integer comId);
}
