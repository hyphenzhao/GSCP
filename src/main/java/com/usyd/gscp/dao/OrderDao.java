package com.usyd.gscp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.usyd.gscp.domain.Order;

@Repository(value = "orderDao")
public class OrderDao{
	@Resource
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public void saveOrder(Order order){
		sessionFactory.getCurrentSession().save(order);
	}
	
	public void updateOrder(Order order){
		sessionFactory.getCurrentSession().update(order);
	}
	
	public Order getOrderById(int id){
		Session session = sessionFactory.openSession();
		try{
    		Order order = (Order) session.get(Order.class, id);
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
		Criteria criteria = session.createCriteria(Order.class);
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
    	Criteria criteria = session.createCriteria(Order.class);
    	List result;
    	criteria.add(
    				Restrictions.eq(status, target)
    			);
    	result = criteria.list();
    	session.close();
    	return result;
    }
}