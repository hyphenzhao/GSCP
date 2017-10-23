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

import com.usyd.gscp.domain.Degree;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class DegreeDaoTest {
	
	@Autowired
	DegreeDao degreeDao;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetDegreeById() {
		Degree existDegree = degreeDao.getDegreeById(1);
		Degree notExDegree = degreeDao.getDegreeById(0);
		Assert.assertNotNull(existDegree);
		Assert.assertNull(notExDegree);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetAllDegrees() {
		Assert.assertFalse(degreeDao.getAllDegrees().isEmpty());
	}
}
