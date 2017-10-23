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

import com.usyd.gscp.domain.Document;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class DocumentDaoTest {
	
	@Autowired
	DocumentDao documentDao;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testSaveDocument() {
		Document doc = new Document();
		documentDao.saveDocument(doc);
		int id = doc.getId();
		Assert.assertNotEquals(id, 0);
	}

	@Test
    @Transactional
    @Rollback(true)
	public void testGetDocumentByAppId() {
		Assert.assertFalse(documentDao.getDocumentsByAppId(15).isEmpty());
		Assert.assertTrue(documentDao.getDocumentsByAppId(0).isEmpty());
	}
}
