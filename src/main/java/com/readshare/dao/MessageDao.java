package com.readshare.dao;

import java.util.List;

import com.readshare.entity.Message;

/**
 * 对评论进行留言的接口
 * 
 * @author LHY
 *
 */
public interface MessageDao {
	/**
	 * 新建留言信息
	 * 
	 * @param msg
	 * @return
	 */
	int insertMsg(Message msg);

	/**
	 * 删除留言
	 * 
	 * @param msgId
	 */
	int deleteMsg(Integer msgId);

	/**
	 * 更新留言信息,更新回复内容,以及被点赞个数
	 * 
	 * @param msg
	 */
	int updateMsg(Message msg);

	/**
	 * 查找某一条评论的所有留言
	 * 
	 * @return
	 */
	List<Message> queryMsgList(Integer comId);

}
