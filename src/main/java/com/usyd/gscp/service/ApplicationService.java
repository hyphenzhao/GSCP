package com.usyd.gscp.service;

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
}
