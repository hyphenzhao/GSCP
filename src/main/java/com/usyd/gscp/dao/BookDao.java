package com.usyd.gscp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.usyd.gscp.domain.Book;

@Repository(value = "bookyDao")
public class BookDao {

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Book getBookById(int id) {
    	Session session = sessionFactory.openSession();
    	try{
    		Book book =(Book) session.get(Book.class, id);
    		return book;
    	} catch(Exception e) {
    		System.out.println("BookDao.java: Fail to get a book by its id.");
    	}
    	
    	return null;
    }
    
    public List getAllBooks() {
    	Session session = sessionFactory.openSession();
    	try{
    		return session.createCriteria(Book.class).list();
    	} catch(Exception e) {
    		System.out.println("BookDao.java: Fail to get all bookes.");
    	}
    	return null;
    }
}
