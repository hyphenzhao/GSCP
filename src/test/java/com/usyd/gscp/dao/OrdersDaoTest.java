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

import com.usyd.gscp.domain.Orders;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class OrdersDaoTest {
	
	@Autowired
	OrdersDao ordersDao;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testSaveOrders() {
		Orders order = new Orders();
		ordersDao.saveOrder(order);
		int id = order.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetOrdersById() {
		Orders existOrder = ordersDao.getOrderById(1);
		Orders notExOrder = ordersDao.getOrderById(0);
		Assert.assertNotNull(existOrder);
		Assert.assertNull(notExOrder);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetAllBooks() {
		Assert.assertFalse(ordersDao.getAllOrders().isEmpty());
	}
}
