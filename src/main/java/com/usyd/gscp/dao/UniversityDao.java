package com.usyd.gscp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.usyd.gscp.domain.University;

@Repository(value = "universityDao")
public class UniversityDao {

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public University getUniById(int id) {
    	Session session = sessionFactory.openSession();
    	try{
    		University uni = (University) session.get(University.class, id);
    		return uni;
    	} catch(Exception e) {
    		System.out.println("UniversityDao.java: Fail to get a university by its id.");
    	}
    	
    	return null;
    }
    
    public List getAllUnis() {
    	Session session = sessionFactory.openSession();
    	try{
    		return session.createCriteria(University.class).list();
    	} catch(Exception e) {
    		System.out.println("UniversityDao.java: Fail to get all universities.");
    	}
    	return null;
    }
}
