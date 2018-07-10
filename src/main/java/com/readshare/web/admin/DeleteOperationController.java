package com.readshare.web.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.readshare.entity.Book;
import com.readshare.entity.BookShelf;
import com.readshare.entity.User;
import com.readshare.entity.UserLove;
import com.readshare.service.BookShelfService;
import com.readshare.service.CommentService;
import com.readshare.service.UserLoveService;
import com.readshare.util.HttpServletRequestUtil;

/**
 * 用户对书架，评论，收藏的删除操作解析，并实现请求转发与重定向
 * 
 * @author LHY
 *
 */
@Controller
@RequestMapping("/user")
public class DeleteOperationController {
	@Autowired
	private BookShelfService bookshelfService;
	@Autowired
	private CommentService comService;
	@Autowired
	private UserLoveService userloveService;

	@RequestMapping(value = "/operation/delete", method = RequestMethod.GET)
	public ModelAndView operation(HttpServletRequest request, RedirectAttributes attributes) {

		String operation = HttpServletRequestUtil.getString(request, "operate");
		String result = null;

		if (operation.equals("deleteBookself")) {
			// 要执行删除用户书架上的操作
			result = "redirect:/user/operation/deletebookshelf";// 跳转路径
			// 设置参数传递
			attributes.addAttribute("id", request.getParameter("id"));
			attributes.addAttribute("bookId", request.getParameter("bookID"));
		}
		if (operation.equals("deleteLoveBooks")) {
			result = "redirect:/user/operation/deletelovebooks";// 跳转路径
			// 设置参数传递
			attributes.addAttribute("id", request.getParameter("id"));
			attributes.addAttribute("bookId", request.getParameter("bookID"));
			System.out.println(request.getParameter("id") + "+" + request.getParameter("bookID"));
		}
		if (operation.equals("deleteComment")) {
			result = "redirect:/user/operation/deletecomment";// 跳转路径
			// 设置参数传递
			attributes.addAttribute("id", request.getParameter("id"));
			attributes.addAttribute("comId", request.getParameter("comId"));
		}
		System.out.println(result);
		return new ModelAndView(result);
	}

	/**
	 * 删除收藏的书本
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/operation/deletelovebooks", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteLoveBooks(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();

		Integer userId = HttpServletRequestUtil.getInt(request, "id");
		Integer bookId = HttpServletRequestUtil.getInt(request, "bookId");
		if (userId == -1 || bookId == -1) {
			if (userId == -1) {
				modelMap.put("userId", "参数异常,无法正常识别参数id");
			} else {
				modelMap.put("bookId", "参数异常,无法正常识别参数bookId");
			}
			return modelMap;
		}

		User user = new User(userId);
		Book book = new Book(bookId);
		UserLove userlove = new UserLove(user, book);
		int result = userloveService.deleteUserLove(userlove);
		if (result != -1) {// 删除成功
			modelMap.put("deletelovebooks", true);
		} else {
			modelMap.put("deletelovebooks", false);
		}
		return modelMap;
	}

	/**
	 * 删除书架上的书本
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/operation/deletebookshelf", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteBookShelf(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();

		Integer userId = HttpServletRequestUtil.getInt(request, "id");
		Integer bookId = HttpServletRequestUtil.getInt(request, "bookId");
		if (userId == -1 || bookId == -1) {
			if (userId == -1) {
				modelMap.put("userId", "参数异常,无法正常识别参数id");
			} else {
				modelMap.put("bookId", "参数异常,无法正常识别参数bookId");
			}
			return modelMap;
		}

		User user = new User(userId);
		Book book = new Book(bookId);
		BookShelf bookshelf = new BookShelf(user, book);
		int result = bookshelfService.deleteBookFromBookShelf(bookshelf);
		if (result == -1) {// 删除失败
			modelMap.put("deletebookshelf", false);
		}
		modelMap.put("deletebookshelf", true);

		return modelMap;
	}

	/**
	 * 删除评论
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/operation/deletecomment", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteComment(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();

		Integer userId = HttpServletRequestUtil.getInt(request, "id");
		Integer comId = HttpServletRequestUtil.getInt(request, "comId");
		if (userId == -1 || comId == -1) {
			if (userId == -1) {
				modelMap.put("userId", "参数异常,无法正常识别参数id");
			} else {
				modelMap.put("bookId", "参数异常,无法正常识别参数bookId");
			}
			return modelMap;
		}

		int result = comService.deleteComment(comId);
		if (result != -1) {// 删除成功
			modelMap.put("deletecomment", true);
		} else {
			modelMap.put("deletecomment", false);
		}

		return modelMap;
	}

}
