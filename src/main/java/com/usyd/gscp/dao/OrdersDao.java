package com.usyd.gscp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.usyd.gscp.domain.Book;
import com.usyd.gscp.domain.Orders;

@Repository(value = "ordersDao")
public class OrdersDao{
	
	@Resource
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public void saveOrder(Orders order){
		sessionFactory.getCurrentSession().save(order);
	}
	
	public void updateOrder(Orders order){
		sessionFactory.getCurrentSession().update(order);
	}
	
	public void delete(Orders order){
		sessionFactory.getCurrentSession().delete(order);
	}
	
	public List getAllOrders() {
    	Session session = sessionFactory.openSession();
    	try{
    		List result = session.createCriteria(Orders.class).list();
    		session.close();
    		return result;
    	} catch(Exception e) {
    		System.out.println("OrdersDao.java: Fail to get all books.");
    	}
    	session.close();
    	return null;
    }
	
	public Orders getOrderById(int id){
		Session session = sessionFactory.openSession();
		try{
    		Orders order = (Orders) session.get(Orders.class, id);
    		session.close();
    		return order;
    	} catch(Exception e) {
    		System.out.println("OrderDao.java: Fail to get a Order by its id.");
    	}
    	session.close();
    	return null;
	}
	
	public List getOrderByBuyer(String buyer, int id){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Orders.class);
		List result;
		criteria.add(
					Restrictions.eq(buyer, id)
				);
		result = criteria.list();
		session.close();
		return result;
	}
	
	public List getOrderByStatus(String status, String target) {
    	Session session = sessionFactory.openSession();
    	Criteria criteria = session.createCriteria(Orders.class);
    	List result;
    	criteria.add(
    				Restrictions.eq(status, target)
    			);
    	result = criteria.list();
    	session.close();
    	return result;
    }
	
	
}