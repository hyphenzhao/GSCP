package com.usyd.gscp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.gscp.dao.BookDao;
import com.usyd.gscp.domain.Book;

@Service(value = "bookService")
@Transactional
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	public Book getBookById(int id) {
    	return bookDao.getBookById(id);
    }
    
	public Book getBookById(String id) {
    	return bookDao.getBookById(Integer.parseInt(id));
    }
	
	public ArrayList<Book> getAllBooks() {
    	ArrayList<Book> result = (ArrayList<Book>)bookDao.getAllBooks();	
    	return result;
    }
	
	public void createNewBook(Book book){
		bookDao.saveBook(book);
	}
	
	public void uploadBook(Book book) {
		bookDao.saveBook(book);
	}
	
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}
	
	public ArrayList<Book> getBookByOwnerId(int id) {
		ArrayList<Book> result = (ArrayList<Book>) bookDao.getBookByOwner("owner", id);
		return result;
	}
	
	public ArrayList<Book> getBookByStatus(String status){
		ArrayList<Book> result = (ArrayList<Book>) bookDao.getBookByStatus("status", status);
		return result;
	}

}