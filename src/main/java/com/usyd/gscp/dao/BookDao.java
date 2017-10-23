package com.usyd.gscp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.usyd.gscp.domain.Book;

@Repository(value = "bookDao")
public class BookDao {

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void saveBook(Book book) {
    	sessionFactory.getCurrentSession().save(book);
    }
    
    public void updateBook(Book book) {
    	sessionFactory.getCurrentSession().update(book);
    }
    
    public Book getBookById(int id) {
    	Session session = sessionFactory.openSession();
    	try{
    		Book book =(Book) session.get(Book.class, id);
    		session.close();
    		return book;
    	} catch(Exception e) {
    		System.out.println("BookDao.java: Fail to get a book by its id.");
    	}
    	session.close();
    	return null;
    }
    
    public List getAllBooks() {
    	Session session = sessionFactory.openSession();
    	try{
    		List result = session.createCriteria(Book.class).list();
    		session.close();
    		return result;
    	} catch(Exception e) {
    		System.out.println("BookDao.java: Fail to get all books.");
    	}
    	session.close();
    	return null;
    }
    
    public List getBookByOwner(String owner,int id) {
    	Session session = sessionFactory.openSession();
    	Criteria criteria = session.createCriteria(Book.class);
    	List result;
    	criteria.add(
    				Restrictions.eq(owner, id)
    			);
    	result = criteria.list();
    	session.close();
    	return result;
    }
    
    public List getBookByStatus(String status, String target) {
    	Session session = sessionFactory.openSession();
    	Criteria criteria = session.createCriteria(Book.class);
    	List result;
    	criteria.add(
    				Restrictions.eq(status, target)
    			);
    	result = criteria.list();
    	session.close();
    	return result;
    }
}
