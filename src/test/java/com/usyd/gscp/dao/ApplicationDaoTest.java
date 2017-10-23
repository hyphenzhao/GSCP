package com.usyd.gscp.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.gscp.domain.Application;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class ApplicationDaoTest {
	
	@Autowired
	ApplicationDao appDao;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testSaveApplication() {
		Application app = new Application();
		appDao.saveApplication(app);
		int id = app.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetApplicationById() {
		Assert.assertFalse(appDao.getApplicationById("id", 16).isEmpty());
		Assert.assertTrue(appDao.getApplicationById("id", 1).isEmpty());
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testUpdateApplication() {
		Application app = (Application)appDao.getApplicationById("id", 16).get(0);
		app.setTitle("Not_exist_title");
		appDao.updateApplication(app);
		int id = app.getId();
		Assert.assertNotEquals(id, 0);
	}
}
