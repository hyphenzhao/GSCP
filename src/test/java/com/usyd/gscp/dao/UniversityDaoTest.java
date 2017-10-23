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

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class UniversityDaoTest {

	@Autowired
	UniversityDao uniDao;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetUniById() {
		Assert.assertNull(uniDao.getUniById(0));
		Assert.assertNotNull(uniDao.getUniById(1));
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetAllUnis() {
		Assert.assertFalse(uniDao.getAllUnis().isEmpty());
	}
}
