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
 * 用户个人基本信息控制器
 * 
 * @author LHY
 *
 */
@Controller
@RequestMapping("/user/person-info")
public class PersonInfoController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> updateUser(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();
		User user = new User();

		// 从请求参数中获取id
		Integer userId = HttpServletRequestUtil.getInt(request, "id");
		System.out.println("用户id："+request.getParameter("id"));
		System.out.println("用户名："+request.getParameter("name"));
		System.out.println("密码："+request.getParameter("password"));
		System.out.println("头像:"+request.getParameter("icon"));
		
		if (userId == -1) {// 读取用户id不成功
			modelMap.put("updatePersonInfo", false);
			modelMap.put("errMsg", "无法识别用户id");
			return modelMap;
		}
		user.setUserId(userId);// 设置用户的id
		// 需要修改名字
		if (request.getParameter("name") != null) {
			// 从请求参数中获取用户名
			String userName = HttpServletRequestUtil.getString(request, "name");
			user.setUserName(userName);
		}
		if (request.getParameter("userMobile") != null) {
			// 从请求参数中获取手机号
			String userMobile = HttpServletRequestUtil.getString(request, "userMobile");
			user.setUserMobile(userMobile);
		}
		if (request.getParameter("icon") != null) {
			// 从请求参数中获取头像地址
			String icon = HttpServletRequestUtil.getString(request, "icon");
			user.setIcon(icon);
		}
		if (request.getParameter("password") != null) {
			// 从请求参数中获取密码
			String password = HttpServletRequestUtil.getString(request, "password");
			user.setPassword(password);
		}

		int result = userService.updateUserInfo(user);
		if (result == -1) {// 操作失败
			modelMap.put("updateSucess", false);
			modelMap.put("errMsg", "无法更新个人信息");
		} else {
			modelMap.put("updateSucess", true);
		}
		return modelMap;
	}

}
