package com.usyd.gscp.dao;

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
    
    public boolean checkLogin(String account, String password){
			System.out.println("In Check login");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
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
				userFound= true;
			}

			session.close();
			return userFound;              
    }
}
