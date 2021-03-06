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

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class UniversityServiceTest {
	
	@Autowired
	UniversityService uniService;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetUniById() {
		Assert.assertNotNull(uniService.getUniById(1));
		Assert.assertNull(uniService.getUniById(0));
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetUniByIdString() {
		Assert.assertNotNull(uniService.getUniById("1"));
		Assert.assertNull(uniService.getUniById("0"));
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetAllUnis() {
		Assert.assertFalse(uniService.getAllUnis().isEmpty());
	}
}
