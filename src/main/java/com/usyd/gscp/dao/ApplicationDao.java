package com.usyd.gscp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.usyd.gscp.domain.Application;

@Repository(value = "applicationDao")
public class ApplicationDao {
	@Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void saveApplication(Application application) {
    	sessionFactory.getCurrentSession().save(application);
    }
    
    public List getApplicationById(String role,int id) {
    	Session session = sessionFactory.openSession();
    	Criteria criteria = session.createCriteria(Application.class);
    	List result;
    	criteria.add(
    				Restrictions.eq(role, id)
    			);
    	result = criteria.list();
    	session.close();
    	return result;
    }
}
