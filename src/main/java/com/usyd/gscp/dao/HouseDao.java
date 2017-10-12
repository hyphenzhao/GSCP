package com.usyd.gscp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.usyd.gscp.domain.House;

@Repository(value = "houseDao")
public class HouseDao {
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void saveHouse(House house){
		sessionFactory.getCurrentSession().save(house);
	}
	
	public House getHouseById(int id){
		Session session = sessionFactory.openSession();
    	try{
    		House house =  (House) session.get(House.class, id);
    		session.close();
    		return house;
    	} catch (Exception e) {
    		System.out.println("HouseDao.java: Fail to get a house by its id.");
    	}
	    	session.close();
	    	return null;
	}
	
	public List getAllHouses(){
		Session session = sessionFactory.openSession();
    	try{
    		List result = session.createCriteria(House.class).list();
    		session.close();
    		return result;
    	} catch(Exception e) {
    		System.out.println("HouseDao.java: Fail to get all Houses.");
    	}
	    	session.close();
	    	return null;
	}
}
