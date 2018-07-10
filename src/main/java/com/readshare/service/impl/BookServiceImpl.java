package com.readshare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readshare.dao.BookDao;
import com.readshare.dao.CommentDao;
import com.readshare.dao.MessageDao;
import com.readshare.entity.Book;
import com.readshare.entity.Comment;
import com.readshare.entity.Message;
import com.readshare.service.BookService;

//告诉SpringMVC 需要托管，其他类调用被类时，会动态调用接口注入到接口中
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Autowired
	private CommentDao comDao;
	@Autowired
	private MessageDao msgDao;

	@Override
	public List<Book> getBookList() {
		return bookDao.queryBook();
	}

	@Override
	public List<Book> getBookListByName(String bookName) {

		return bookDao.queryBooksByName(bookName);
	}

	@Override
	public int addBook(Book book) {

		return bookDao.insertBook(book);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);

	}

	@Override
	public List<Comment> queryBookComment(Integer bookId) {
		List<Comment> comList = comDao.queryCommentByBookId(bookId);
		return comList;
	}

	@Override
	public Book getBookById(Integer bookId) {
		Book book = bookDao.queryBookById(bookId);
		List<Comment> bookCom = comDao.queryCommentByBookId(bookId);
		List<Message> msgList = null;
		for (int i = 0; i < bookCom.size(); i++) {
			msgList = msgDao.queryMsgList(bookCom.get(i).getComId());
			bookCom.get(i).setReply(msgList);
		}
		book.setBookCom(bookCom);
		return book;
	}

	@Override
	public Book queryBookById(Integer bookId) {

		return bookDao.queryBookById(bookId);
	}

}
