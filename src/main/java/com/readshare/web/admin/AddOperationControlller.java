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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.readshare.entity.Book;
import com.readshare.entity.BookShelf;
import com.readshare.entity.Comment;
import com.readshare.entity.ReadRecord;
import com.readshare.entity.User;
import com.readshare.entity.UserLove;
import com.readshare.service.BookService;
import com.readshare.service.BookShelfService;
import com.readshare.service.CommentService;
import com.readshare.service.ReadRecordService;
import com.readshare.service.UserLoveService;
import com.readshare.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/user")
public class AddOperationControlller {
	@Autowired
	private BookShelfService bsService;
	@Autowired
	private UserLoveService userloveService;
	@Autowired
	private ReadRecordService rrService;
	@Autowired
	private CommentService comService;
	@Autowired
	private BookService bookService;

	@RequestMapping("/operation/add")
	public ModelAndView operation(HttpServletRequest request, RedirectAttributes attributes) {

		// 要执行的操作
		String operation = HttpServletRequestUtil.getString(request, "operate");
		String result = null;

		// 用户添加书本到书架上的操作
		if (operation.equals("bookshelfChange")) {
			result = "redirect:/user/operation/bookshelfchange";// 跳转路径
			// 设置参数传递
			attributes.addAttribute("userId", request.getParameter("userId"));
			attributes.addAttribute("bookID", request.getParameter("bookId"));
			attributes.addAttribute("bookName", request.getParameter("bookName"));
			attributes.addAttribute("photoUrl", request.getParameter("photoUrl"));
		}
		// 用户添加书本到收藏列表
		if (operation.equals("loveBooksChange")) {
			result = "redirect:/user/operation/lovebookschange";// 跳转路径
			// 设置参数传递
			attributes.addAttribute("userId", request.getParameter("userId"));
			attributes.addAttribute("bookID", request.getParameter("bookId"));
			attributes.addAttribute("bookName", request.getParameter("bookName"));
			attributes.addAttribute("photoUrl", request.getParameter("photoUrl"));

		}

		// 用户添加阅读记录
		if (operation.equals("readChange")) {
			result = "redirect:/user/operation/readchange";// 跳转路径
			// 设置参数传递
			attributes.addAttribute("userId", request.getParameter("userId"));
			attributes.addAttribute("bookID", request.getParameter("bookId"));
			attributes.addAttribute("bookName", request.getParameter("bookName"));
			attributes.addAttribute("photoUrl", request.getParameter("photoUrl"));
		}
		// 用户添加评论
		if (operation.equals("addComment")) {
			result = "redirect:/user/operation/addcomment";// 跳转路径
			// 设置参数传递
			attributes.addAttribute("userId", request.getParameter("userID"));
			attributes.addAttribute("bookId", request.getParameter("bookId"));
			attributes.addAttribute("bookName", request.getParameter("bookName"));
			attributes.addAttribute("mark", request.getParameter("mark"));
			attributes.addAttribute("photoUrl", request.getParameter("photoUrl"));
		}
		System.out.println(result);
		return new ModelAndView(result);
	}

	/**
	 * 添加书架上的书本
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/operation/bookshelfchange", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addBookShelf(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();

		Integer userId = HttpServletRequestUtil.getInt(request, "userId");
		Integer bookId = HttpServletRequestUtil.getInt(request, "bookID");
		System.out.println("加入书架:" + userId + "+" + bookId);
		if (userId == -1 || bookId == -1) {
			modelMap.put("userId", "参数异常,无法正常识别参数userId或bookID");
			System.out.println("参数异常,无法正常识别参数userId或bookID");
			return modelMap;
		}

		// 数据库中没有该书本的信息

		if (bookService.queryBookById(bookId) == null) {
			String photoUrl = HttpServletRequestUtil.getString(request, "photoUrl");
			String bookName = HttpServletRequestUtil.getString(request, "bookName");
			Book book = new Book(bookId, bookName, photoUrl);
			System.out.println("加入书架:" + book);
			int result = bookService.addBook(book);
			if (result == -1) {
				System.out.println("插入书本失败!");
				modelMap.put("errMsg", "书本不存在");
				return modelMap;
			}
		}
		User user = new User(userId);
		Book book = new Book(bookId);
		BookShelf bookshelf = new BookShelf(user, book);

		int result = bsService.addBookToBookShelf(bookshelf);
		System.out.println(result);
		if (result != -1) {// 删除成功
			modelMap.put("bookshelfchange", true);
		} else {
			modelMap.put("bookshelfchange", false);
		}
		return modelMap;
	}

	/**
	 * 添加收藏的书本
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/operation/lovebookschange", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addLoveBooks(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();

		Integer userId = HttpServletRequestUtil.getInt(request, "userId");
		Integer bookId = HttpServletRequestUtil.getInt(request, "bookID");

		System.out.println("加入收藏:" + userId + "+" + bookId);
		if (userId == -1 || bookId == -1) {
			if (userId == -1) {
				modelMap.put("userId", "参数异常,无法正常识别参数id");
			} else {
				modelMap.put("bookId", "参数异常,无法正常识别参数bookID");
			}
			return modelMap;
		}
		// 数据库中没有该书本的信息
		if (bookService.queryBookById(bookId) == null) {
			String photoUrl = HttpServletRequestUtil.getString(request, "photoUrl");
			String bookName = HttpServletRequestUtil.getString(request, "bookName");
			Book book = new Book(bookId, bookName, photoUrl);
			int result = bookService.addBook(book);
			if (result == -1) {
				System.out.println("插入书本失败!");
				modelMap.put("errMsg", "书本不存在");
				return modelMap;
			}
		}

		User user = new User(userId);
		Book book = new Book(bookId);
		UserLove userlove = new UserLove(user, book);
		int result = userloveService.insertUserLove(userlove);
		if (result != -1) {// 删除成功
			modelMap.put("lovebookschange", true);
		} else {
			modelMap.put("lovebookschange", false);
		}
		return modelMap;
	}

	/**
	 * 添加已读记录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/operation/readchange", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addReadRecord(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();

		Integer userId = HttpServletRequestUtil.getInt(request, "userId");
		Integer bookId = HttpServletRequestUtil.getInt(request, "bookID");
		System.out.println("加入已读:" + userId + "+" + bookId);
		if (userId == -1 || bookId == -1) {
			if (userId == -1) {
				modelMap.put("userId", "参数异常,无法正常识别参数id");
			} else {
				modelMap.put("bookID", "参数异常,无法正常识别参数bookID");
			}
			return modelMap;
		}
		// 数据库中没有该书本的信息
		if (bookService.queryBookById(bookId) == null) {
			String photoUrl = HttpServletRequestUtil.getString(request, "photoUrl");
			String bookName = HttpServletRequestUtil.getString(request, "bookName");
			Book book = new Book(bookId, bookName, photoUrl);
			int result = bookService.addBook(book);
			if (result == -1) {
				System.out.println("插入书本失败!");
				modelMap.put("errMsg", "书本不存在");
				return modelMap;
			}
		}

		ReadRecord readrecord = new ReadRecord(new User(userId), new Book(bookId));
		int result = rrService.insertRR(readrecord);
		if (result != -1) {// 删除成功
			modelMap.put("readchange", true);
		} else {
			modelMap.put("readchange", false);
		}
		return modelMap;
	}

	/**
	 * 添加收藏的书本
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/operation/addcomment", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addComment(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();

		Integer userId = HttpServletRequestUtil.getInt(request, "userId");
		Integer bookId = HttpServletRequestUtil.getInt(request, "bookId");
		String mark = HttpServletRequestUtil.getString(request, "mark");
		System.out.println("用户 ID:" + request.getParameter("userId"));
		System.out.println("书本id:" + bookId);
		System.out.println("评论内容" + mark);
		System.out.println("书名:" + request.getParameter("bookName"));
		System.out.println("书本封面:" + request.getParameter("photoUrl"));

		if (userId == -1 || bookId == -1) {
			modelMap.put("userId", "参数异常,无法正常识别参数id或bookId");
			System.out.println("参数异常,无法正常识别参数id或bookId");
			return modelMap;
		}
		if (mark == null) {
			modelMap.put("mark", "评论内容不能为空或无法识别评论内容");
			System.out.println("评论内容不能为空或无法识别评论内容");
			return modelMap;
		}

		// 数据库中没有该书本的信息
		if (bookService.queryBookById(bookId) == null) {
			String photoUrl = HttpServletRequestUtil.getString(request, "photoUrl");
			String bookName = HttpServletRequestUtil.getString(request, "bookName");
			Book book = new Book(bookId, bookName, photoUrl);
			int result = bookService.addBook(book);
			if (result == -1) {
				System.out.println("插入书本失败!");
				modelMap.put("errMsg", "书本不存在");
				return modelMap;
			}
		}
		Comment comment = new Comment();
		comment.setBookId(bookId);// 设置评论书本
		comment.setUserId(userId);// 设置评论用户
		comment.setMark(mark);// 设置评论内容
		comment.setCreateTime(new Date());// 设置评论时间

		int result = comService.addComment(comment);
		if (result == -1) {// 添加评论失败
			modelMap.put("addComment", false);
			modelMap.put("errMsg", "评论失败");
		} else {
			modelMap.put("addComment", true);
		}
		System.out.println(comment);
		return modelMap;
	}
}
