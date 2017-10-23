package com.usyd.gscp.dao;

import com.usyd.gscp.domain.*;

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
public class ForumCommentDaoTest {
	
	@Autowired
	ForumCommentDao commentDao;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testSaveForumComment() {
		ForumComment comment = new ForumComment();
		commentDao.saveForumComment(comment);
		int id = comment.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testUpdateForumComment() {
		ForumComment comment = (ForumComment)commentDao.getCommentById("id", 1).get(0);
		comment.setContent("new content");
		commentDao.updateForumComment(comment);
		int id = comment.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetCommentById() {
		Assert.assertFalse(commentDao.getCommentById("id", 1).isEmpty());
		Assert.assertTrue(commentDao.getCommentById("id", 0).isEmpty());
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetAllComments() {
		Assert.assertFalse(commentDao.getAllComments().isEmpty());
	}
}
