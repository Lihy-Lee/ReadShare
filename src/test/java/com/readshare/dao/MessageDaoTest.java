package com.readshare.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readshare.BaseTest;
import com.readshare.entity.Comment;
import com.readshare.entity.Message;
import com.readshare.entity.User;

public class MessageDaoTest extends BaseTest {
	@Autowired
	private MessageDao msgDao;

	public void testInsertMsg() {
		Message msg = new Message();
		Comment comment = new Comment();
		comment.setComId(1);
		//msg.setComment(comment);

		User user = new User();
		user.setUserId(1);
		//msg.setUser(user);

		msg.setMark("我也有怀疑");
		msg.setCreateTime(new Date());

		msgDao.insertMsg(msg);

	}

	public void testUpdateMsg() {
		Message msg = new Message();
		msg.setReplyId(5);
		msg.setMark("不用怀疑");
		msgDao.updateMsg(msg);
		msg.setReplyId(1);
		msg.setMark("是真的");
	}

	
	public void testQueryMsg() {
		//Message msg = new Message();
		Comment comment = new Comment();
		comment.setComId(1);
		//msg.setComment(comment);

		List<Message> msgList = msgDao.queryMsgList(1);
		System.out.println(msgList);
		//assertEquals(2,msgList.size());
	}


	public void testDeleteMsg() {
		msgDao.deleteMsg(5);
	}
}
