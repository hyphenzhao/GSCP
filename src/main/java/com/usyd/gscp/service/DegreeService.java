package com.usyd.gscp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.gscp.dao.DegreeDao;
import com.usyd.gscp.domain.Degree;

@Service(value = "degreeService")
@Transactional
public class DegreeService {
	
	@Autowired
	private DegreeDao degreeDao;
	
	public Degree getDegreeById(int id) {
    	return degreeDao.getDegreeById(id);
    }
    
    public Degree getDegreeById(String id) {
    	return degreeDao.getDegreeById(Integer.parseInt(id));
    }
    
    public ArrayList<Degree> getAllDegrees() {
    	ArrayList<Degree> result = (ArrayList<Degree>)degreeDao.getAllDegrees();
    	
    	return result;
    }
}
