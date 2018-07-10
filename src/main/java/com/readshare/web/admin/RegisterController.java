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
/**
 * 用户注册管理
 * @author LHY
 *
 */
@Controller
@RequestMapping("/user") // 指定访问路径
public class RegisterController {
	@Autowired
	private UserService userService;

	/**
	 * 注册新用户
	 * 
	 * @param request
	 *            客户端的请求，当用户通过HTTP请求时，通过请求可以拿到用户的所有信息
	 * @return 返回一些必要的键值对结果
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@ResponseBody // 将对象自动转化成json文件
	public Map<String, Object> registerUser(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();

		// 1.接收并转化相应的参数
		// String userString = HttpServletRequestUtil.getString(request, "userString");
		// String userString = null;
		String userName = HttpServletRequestUtil.getString(request, "userName");
		String userPhone = HttpServletRequestUtil.getString(request, "userPhone");
		String userPassword = HttpServletRequestUtil.getString(request, "userPassword");

		if (userService.queryUserByMobile(userPhone) != null) {
			// 根据手机号查询信息数据库，若数据库中该手机号的用户存在(即返回值为不为null)，则注册失败。
			modelMap.put("success", false);
			modelMap.put("errMsg", "该手机号已经被注册");
			return modelMap;
		}

		// userString = "userName:" + userName + "," + "userMobile:" + userPhone + "," +
		// "password:" + userPassword;

		// ObjectMapper mapper = new ObjectMapper();
		User user = new User(userName, userPhone, userPassword);

		// 2.注册用户

		int userId = userService.addUser(user);
		if (userId != -1) {// 注册成功
			modelMap.put("success", true);
			modelMap.put("userId", userId);
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "用户注册失败");
		}

		// 3.返回结果
		return modelMap;
	}

}
