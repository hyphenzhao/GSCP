package com.usyd.gscp.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.gscp.domain.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class UserDaoTest{
	
	@Autowired
	private UserDao userDao;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetAllUsers() {
		List users = userDao.getAllUsers();
		Assert.assertFalse(users.isEmpty());
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testSaveUser() {
		User user = new User();
		userDao.saveUser(user);
		int id = user.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testUpdateUser() {
		String email = "not_exist@email.com";
		User user = userDao.getUserById(1);
		user.setEmail(email);
		userDao.updateUser(user);
		int id = user.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetUserById() {
		Assert.assertNull(userDao.getUserById(0));
		Assert.assertNotNull(userDao.getUserById(1));
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testCheckLogin() {
		String username = "Hiphon";
		String rightpwd = "E10ADC3949BA59ABBE56E057F20F883E";
		String wrongpwd = "123456";
		
		Assert.assertNotEquals(userDao.checkLogin(username, rightpwd), -1);
		Assert.assertEquals(userDao.checkLogin(username, wrongpwd), -1);
	}
}
