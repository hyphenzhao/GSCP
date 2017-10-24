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
import com.usyd.gscp.domain.House;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class HouseDaoTest {
	
	@Autowired
	HouseDao houseDao;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetDegreeById() {
		House house1 = houseDao.getHouseById(1);
		House house2 = houseDao.getHouseById(0);
		Assert.assertNotNull(house1);
		Assert.assertNull(house2);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetAllHouses() {
		Assert.assertFalse(houseDao.getAllHouses().isEmpty());
	}
}
