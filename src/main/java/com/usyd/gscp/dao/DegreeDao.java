package com.usyd.gscp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.usyd.gscp.domain.Degree;

@Repository(value = "degreeDao")
public class DegreeDao {

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Degree getDegreeById(int id) {
    	Session session = sessionFactory.openSession();
    	try{
    		Degree degree = (Degree) session.get(Degree.class, id);
    		session.close();
    		return degree;
    	} catch(Exception e) {
    		System.out.println("DegreeDao.java: Fail to get a Degree by its id.");
    	}
    	session.close();
    	return null;
    }
    
    public List getAllDegrees() {
    	Session session = sessionFactory.openSession();
    	try{
    		List result = session.createCriteria(Degree.class).list();
    		session.close();
    		return result;
    	} catch(Exception e) {
    		System.out.println("DegreeDao.java: Fail to get all Degrees.");
    	}
    	session.close();
    	return null;
    }
}
