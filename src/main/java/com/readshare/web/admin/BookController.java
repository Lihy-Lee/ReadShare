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

import com.readshare.entity.Book;
import com.readshare.entity.Comment;
import com.readshare.service.BookShelfService;
import com.readshare.service.CommentService;
import com.readshare.service.ReadRecordService;
import com.readshare.service.UserLoveService;
import com.readshare.util.HttpServletRequestUtil;


@Controller
@RequestMapping("/book") // 指定访问路径
public class BookController {

	@Autowired
	private CommentService comService;
	@Autowired
	private BookShelfService bookshelfService;
	@Autowired
	private UserLoveService userloveService;
	@Autowired
	private ReadRecordService rrService;
	

	@RequestMapping(value = "/comments", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getBookComments(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();
		// 读取参数
		int bookId = HttpServletRequestUtil.getInt(request, "bookId");
		int userId = HttpServletRequestUtil.getInt(request, "userId");
		if (bookId == -1 || userId == -1) {
			modelMap.put("errMsg", "无法识别userId或bookId");
		}

		// 根据书本id查询书本的所有评论
		List<Comment> comList = comService.queryCommentByBookId(bookId);
		modelMap.put("comments", comList);
		modelMap.put("boolLove", false);// 默认书本不在收藏列表
		modelMap.put("boolBookshelf", false);// 默认书本不在书架上
		modelMap.put("boolRead", false);// 默认书本不在已读列表
		
		// 根据用户id查询书架上的书
		List<Book> bookshelfList = bookshelfService.queryBookFromBookShelf(userId);

	
		for (int i = 0; i < bookshelfList.size(); i++) {
			if (bookId == bookshelfList.get(i).getBookId()) {
				modelMap.put("boolBookshelf", true);
				break;
			}
		}

		// 根据用户id查询用户收藏列表
		List<Book> userloveList = userloveService.queryUserLoveByUserId(userId);
		for (int i = 0; i < userloveList.size(); i++) {
			if (bookId == userloveList.get(i).getBookId()) {
				modelMap.put("boolLove", true);
				break;
			}
		}

		// 根据用户id查询用户已读列表
		List<Book> rrList = rrService.queryRR(userId);
		for (int i = 0; i < rrList.size(); i++) {
			if (bookId == rrList.get(i).getBookId()) {
				modelMap.put("boolRead", true);
				break;
			}
		}

		return modelMap;
	}

}
