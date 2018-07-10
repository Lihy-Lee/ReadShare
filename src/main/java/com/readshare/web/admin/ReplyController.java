package com.readshare.web.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readshare.entity.Message;
import com.readshare.service.MessageService;
import com.readshare.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/book/comments")
public class ReplyController {

	@Autowired
	private MessageService msgService;

	@RequestMapping(value = "/reply", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> setReply(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();
		// 被评论的id
		int comId = HttpServletRequestUtil.getInt(request, "comId");
		// 用户id
		int userId = HttpServletRequestUtil.getInt(request, "userId");
		// 评论内容
		String mark = HttpServletRequestUtil.getString(request, "mark");
		//String beReply = HttpServletRequestUtil.getString(request, "beReply");
		if (comId == -1 || userId == -1) {
			modelMap.put("errMsg", "无法识别userId或comId");
		}

		System.out.println("用户id:" + userId + "+" + "评论id:" + comId);

		Message msg = new Message();
		msg.setComId(comId);
		msg.setUserId(userId);
		msg.setMark(mark);
		msg.setCreateTime(new Date());
		//msg.setBeReply(beReply);

		int result = msgService.insertMsg(msg);

		if (result == -1) {
			modelMap.put("reply", false);
		} else {
			modelMap.put("reply", true);
			modelMap.put("replyId", msg.getReplyId());
		}
		return modelMap;
	}

	@RequestMapping(value = "/reply/update", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> updateReply(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();

		// 用户id
		int replyId = HttpServletRequestUtil.getInt(request, "replyId");
		// 评论内容
		String beReply = HttpServletRequestUtil.getString(request, "beReply");

		if (replyId == -1) {
			modelMap.put("errMsg", "无法识别replyId");
		}

		System.out.println("留言id:" + replyId);
		System.out.println("回复内容:" + beReply);

		Message msg = new Message();
		msg.setReplyId(replyId);
		msg.setBeReply(beReply);

		int result = msgService.updateMsg(msg);

		if (result == -1) {
			modelMap.put("reply", false);
		} else {
			modelMap.put("reply", true);
		}
		return modelMap;
	}
}
