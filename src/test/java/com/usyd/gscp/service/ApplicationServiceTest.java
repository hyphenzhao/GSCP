package com.usyd.gscp.service;

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
public class ApplicationServiceTest {

	@Autowired
	ApplicationService appService;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testUploadApplication() {
		Application app = new Application();
		appService.uploadApplication(app);
		int id = app.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testUpdateApplication() {
		Application app = (Application) appService.getApplicationById(16).get(0);
		app.setContent("new content");
		appService.updateApplication(app);
		int id = app.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetApplicationByStudentId() {
		Assert.assertFalse(appService.getApplicationByStudentId(1).isEmpty());
		Assert.assertTrue(appService.getApplicationByStudentId(0).isEmpty());
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetApplicationByAgentId() {
		Assert.assertFalse(appService.getApplicationByAgentId(2).isEmpty());
		Assert.assertTrue(appService.getApplicationByAgentId(0).isEmpty());
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetApplicationById() {
		Assert.assertFalse(appService.getApplicationById(16).isEmpty());
		Assert.assertTrue(appService.getApplicationById(0).isEmpty());
	}
}
