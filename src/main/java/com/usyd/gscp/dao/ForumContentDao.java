package com.usyd.gscp.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
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
}
