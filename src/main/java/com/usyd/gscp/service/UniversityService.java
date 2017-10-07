package com.usyd.gscp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.gscp.dao.UniversityDao;
import com.usyd.gscp.domain.University;

@Service(value = "universityService")
@Transactional
public class UniversityService {
	@Autowired
	private UniversityDao uniDao;
	
	public University getUniById(int id) {
    	return uniDao.getUniById(id);
    }
    
    public University getUniById(String id) {
    	return uniDao.getUniById(Integer.parseInt(id));
    }
    
    public ArrayList<University> getAllUnis() {
    	ArrayList<University> result = (ArrayList<University>)uniDao.getAllUnis();
    	
    	return result;
    }
}
