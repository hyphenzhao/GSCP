package com.usyd.gscp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.usyd.gscp.domain.Document;

@Repository(value = "documentDao")
public class DocumentDao {
	
	@Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void saveDocument(Document document) {
        sessionFactory.getCurrentSession().save(document);
    }
    
    public List getDocumentsByAppId(int id) {
    	Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Document.class);
		criteria.add(
					Restrictions.eq("applicationId", id)
				);
		List result = criteria.list();
		session.close();
		return result;
    }
}
