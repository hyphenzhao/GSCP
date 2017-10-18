package com.usyd.gscp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.gscp.dao.ApplicationDao;
import com.usyd.gscp.domain.Application;

@Service(value = "applicationService")
@Transactional
public class ApplicationService {
	
	@Autowired
	private ApplicationDao applicationDao;
	
	public void uploadApplication(Application application) {
		applicationDao.saveApplication(application);
	}
	
	public void updateApplication(Application application) {
		applicationDao.updateApplication(application);
	}
	
	public ArrayList<Application> getApplicationByStudentId(int id) {
		ArrayList<Application> result =(ArrayList<Application>) applicationDao.getApplicationById("studentId", id);
		return result;
	}
	
	public ArrayList<Application> getApplicationByAgentId(int id) {
		ArrayList<Application> result =(ArrayList<Application>) applicationDao.getApplicationById("agentId", id);
		return result;
	}
	
	public ArrayList<Application> getApplicationById(int id) {
		ArrayList<Application> result =(ArrayList<Application>) applicationDao.getApplicationById("id", id);
		return result;
	}
}
