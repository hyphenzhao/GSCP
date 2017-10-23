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
public class DocumentServiceTest {

	@Autowired
	DocumentService docService;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetDocumentByAppId() {
		Assert.assertFalse(docService.getDocumentsByAppId(16).isEmpty());
		Assert.assertTrue(docService.getDocumentsByAppId(0).isEmpty());
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetSaltString() {
		String str = docService.getSaltString();
		Assert.assertNotNull(str);
		Assert.assertEquals(str.length(), 18);
	}
}
