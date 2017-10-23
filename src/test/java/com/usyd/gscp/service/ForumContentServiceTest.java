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

import com.usyd.gscp.domain.ForumContent;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class ForumContentServiceTest {
	
	@Autowired
	ForumContentService contentService;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testCreateNewComment() {
		ForumContent content = new ForumContent();
		contentService.createNewContent(content);
		int id = content.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testUpdateComment() {
		ForumContent content = contentService.getCotentById(2);
		content.setContent("new content");
		contentService.updateContent(content);
		int id = content.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetCommentById() {
		Assert.assertNotNull(contentService.getCotentById(2));
		Assert.assertNull(contentService.getCotentById(0));
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetAllComments() {
		Assert.assertFalse(contentService.getAllCotents().isEmpty());
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetCommentByUserId() {
		Assert.assertFalse(contentService.getCotentByUserId(1).isEmpty());
		Assert.assertTrue(contentService.getCotentByUserId(0).isEmpty());
	}
}
