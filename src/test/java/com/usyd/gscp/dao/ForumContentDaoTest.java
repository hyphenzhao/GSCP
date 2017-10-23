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

import com.usyd.gscp.domain.ForumContent;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class ForumContentDaoTest {
	
	@Autowired
	ForumContentDao contentDao;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testSaveForumContent() {
		ForumContent content = new ForumContent();
		contentDao.saveForumContent(content);
		int id = content.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testUpdateForumContent() {
		ForumContent content = (ForumContent) contentDao.getContentById("id", 2).get(0);
		content.setContent("new content");
		int id = content.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetContentById() {
		Assert.assertFalse(contentDao.getContentById("id", 3).isEmpty());
		Assert.assertTrue(contentDao.getContentById("id", 1).isEmpty());
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetAllContent() {
		Assert.assertFalse(contentDao.getAllContent().isEmpty());
	}
}
