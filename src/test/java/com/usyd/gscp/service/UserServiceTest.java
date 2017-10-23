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

import com.usyd.gscp.domain.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetAllUsers() {
		Assert.assertFalse(userService.getAllUsers().isEmpty());
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetUserById() {
		Assert.assertNotNull(userService.getUserById(1));
		Assert.assertNull(userService.getUserById(0));
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetUserByIdString() {
		Assert.assertNotNull(userService.getUserById("1"));
		Assert.assertNull(userService.getUserById("0"));
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetUserByRole() {
		Assert.assertFalse(userService.getUsersByRole(32).isEmpty());
		Assert.assertTrue(userService.getUsersByRole(0).isEmpty());
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testAuthenticateUser() {
		Assert.assertNotEquals(userService.authenticateUser("hiphon@123.com", "123456"), -1);
		Assert.assertEquals(userService.authenticateUser("hiphon@123.com", ""), -1);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testRegisterUser() {
		User user = new User();
		userService.registerUser(user);
		int id = user.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testUpdateUser() {
		User user = userService.getUserById(1);
		user.setEmail("not_exist@email.com");
		userService.updateUser(user);
		int id = user.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testHashCode() {
		String hashStr = userService.hashCode("123456");
		Assert.assertEquals(hashStr, "E10ADC3949BA59ABBE56E057F20F883E");
	}
}
