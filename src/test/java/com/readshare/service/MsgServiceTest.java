package com.readshare.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readshare.BaseTest;
import com.readshare.entity.Message;
import com.readshare.service.MessageService;

public class MsgServiceTest extends BaseTest {
	@Autowired
	private MessageService msgService;

	public void testInsertMsg() {
		Message msg = new Message();
		msg.setUserId(3);
		msg.setComId(1);
		msg.setMark("I am a girl");
		msg.setCreateTime(new Date());
		msgService.insertMsg(msg);
	}

	public void testUpdateMsg() {
		Message msg = new Message();
		msg.setReplyId(6);
		msg.setMark("hello");
		msg.setSupport(1);
		msgService.updateMsg(msg);
	}

	public void testQueryMsg() {
		List<Message> msgList = msgService.queryMsgList(1);
		System.out.println(msgList);
	}


	public void testDeleteMsg() {
		msgService.deleteMsg(1);

	}
}
