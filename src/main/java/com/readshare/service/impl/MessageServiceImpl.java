package com.readshare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readshare.dao.MessageDao;
import com.readshare.entity.Message;
import com.readshare.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDao msgDao;

	@Override
	public int insertMsg(Message msg) {
		
		return msgDao.insertMsg(msg);
	}

	@Override
	public int deleteMsg(Integer msgId) {
		return msgDao.deleteMsg(msgId);
	}

	@Override
	public int updateMsg(Message msg) {

		return msgDao.updateMsg(msg);
	}

	@Override
	public List<Message> queryMsgList(Integer comId) {

		return msgDao.queryMsgList(comId);
	}

}
