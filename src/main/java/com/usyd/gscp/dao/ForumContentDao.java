package com.usyd.gscp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.usyd.gscp.domain.ForumContent;

@Repository(value = "forumContentDao")
public class ForumContentDao {
	@Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void saveForumContent(ForumContent content) {
    	sessionFactory.getCurrentSession().save(content);
    }
    
    public void updateForumContent(ForumContent content) {
    	sessionFactory.getCurrentSession().update(content);
    }
    
    public List getContentById(String role, int id) {
    	Session session = sessionFactory.openSession();
    	Criteria criteria = session.createCriteria(ForumContent.class);
    	criteria.add(
    				Restrictions.and(
						Restrictions.eq(role, id), 
						Restrictions.eq("visability", Boolean.TRUE)
    				)
    			);
    	List result = criteria.list();
    	session.close();
    	return result;
    }
    
    public List getAllContent() {
    	Session session = sessionFactory.openSession();
    	try{
    		Criteria criteria = session.createCriteria(ForumContent.class);
    		criteria.add(
    					Restrictions.eq("visability", Boolean.TRUE)
    				);
    		List result = criteria.list();
    		session.close();
    		return result;
    	} catch(Exception e) {
    		System.out.println("ForumContentDao.java: Fail to get all contents.");
    	}
    	session.close();
    	return null;
    }
}
