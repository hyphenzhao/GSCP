package com.usyd.gscp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.usyd.gscp.domain.User;

@Repository(value = "userDao")
public class UserDao {
	
    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
    
    public void updateUser(User user) {
    	sessionFactory.getCurrentSession().update(user);
    }
    
    public User getUserById(int id) {
    	Session session = sessionFactory.openSession();
    	try{
    		User user =  (User) session.get(User.class, id);
    		return user;
    	} catch (Exception e) {
    		System.out.println("UserDao.java: Fail to get a user by its id.");
    	}
    	
    	return null;
    }
    
    public int checkLogin(String account, String password){
    	
			System.out.println("In Check login");
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(
					Restrictions.and(
							Restrictions.eq("password", password),
							Restrictions.or(
									Restrictions.eq("email", account),
									Restrictions.eq("username", account)
									)
							)
					);
			List list = criteria.list();

			if ((list != null) && (list.size() > 0)) {
				ArrayList<User> userList = (ArrayList<User>) list;
				return userList.get(0).getId();
				
			}

			session.close();
			return -1;              
    }
}
