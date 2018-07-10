package com.readshare.web.admin;

import java.util.HashMap;
import java.util.List;
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

/**
 * 用户登录管理
 * 
 * @author LHY
 *
 */
@Controller
@RequestMapping("/user") // 指定访问路径
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody // 将对象自动转化成json文件
	public Map<String, Object> login(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();

		String userMobile = HttpServletRequestUtil.getString(request, "userName");
		String password = HttpServletRequestUtil.getString(request, "userPassword");
		User user = userService.queryUserByMobile(userMobile);
		if (user == null) {// 用户不存在
			modelMap.put("loginSuccess", false);
			modelMap.put("errMsg", "用户不存在");
		}
		// System.out.println(user.getPassword().equals(password));
		if (user.getPassword().equals(password)) {// 密码相同
			modelMap.put("loginSuccess", true);
			// 根据当前用户的id查询用户，可以查询到用户的所有信息，包括收藏，书架，阅读记录等
			// User newUser = userService.queryUserById(user.getUserId());
			modelMap.put("id", user.getUserId());
			// modelMap.put("user", newUser);
		} else {
			modelMap.put("loginSuccess", false);
			modelMap.put("errMsg", "密码错误");
		}

		return modelMap;
	}

	@RequestMapping(value = "/alluser", method = RequestMethod.GET)
	@ResponseBody // 将对象自动转化成json文件
	public Map<String, Object> allUser(HttpServletRequest request) {
		List<User> userList = userService.queryAllUser();
		Map<String, Object> modelMap = new HashMap<>();
		for (int i = 0; i < userList.size(); i++) {
			User user = userService.queryUserById(userList.get(i).getUserId());
			userList.set(i, user);
		}
		modelMap.put("user", userList);
		return modelMap;
	}

}
