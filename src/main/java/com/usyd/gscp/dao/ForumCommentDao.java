package com.usyd.gscp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.usyd.gscp.domain.ForumComment;
import com.usyd.gscp.domain.ForumContent;

@Repository(value = "forumCommentDao")
public class ForumCommentDao {
	@Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void saveForumComment(ForumComment comment) {
    	sessionFactory.getCurrentSession().save(comment);
    }
    
    public void updateForumComment(ForumComment comment) {
    	sessionFactory.getCurrentSession().update(comment);
    }
    
    public List getCommentById(String role, int id) {
    	Session session = sessionFactory.openSession();
    	Criteria criteria = session.createCriteria(ForumComment.class);
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
    
    public List getAllComments() {
    	Session session = sessionFactory.openSession();
    	try{
    		Criteria criteria = session.createCriteria(ForumComment.class);
    		criteria.add(
    					Restrictions.eq("visability", Boolean.TRUE)
    				);
    		List result = criteria.list();
    		session.close();
    		return result;
    	} catch(Exception e) {
    		System.out.println("ForumCommentDao.java: Fail to get all comments.");
    	}
    	session.close();
    	return null;
    }
}
