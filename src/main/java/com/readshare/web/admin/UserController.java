package com.readshare.web.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readshare.entity.User;
import com.readshare.service.UserService;
import com.readshare.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;


	@ResponseBody
	@RequestMapping(value="/getusermsg", method = RequestMethod.GET)
	public Map<String, Object> getUserMsg(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();

		Integer userId = HttpServletRequestUtil.getInt(request, "userId");
		User user = userService.queryUserById(userId);
		
		modelMap.put("user", user);
		return modelMap;
	}

}
