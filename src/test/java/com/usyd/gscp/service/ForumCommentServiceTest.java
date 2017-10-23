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

import com.usyd.gscp.domain.ForumComment;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class ForumCommentServiceTest {
	
	@Autowired
	ForumCommentService commentService;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testCreateNewComment() {
		ForumComment comment = new ForumComment();
		commentService.createNewComment(comment);
		int id = comment.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testUpdateComment() {
		ForumComment comment = commentService.getCommentById(1);
		comment.setContent("new content");
		commentService.updateComment(comment);
		int id = comment.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetCommentById() {
		Assert.assertNotNull(commentService.getCommentById(2));
		Assert.assertNull(commentService.getCommentById(0));
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetAllComments() {
		Assert.assertFalse(commentService.getAllComments().isEmpty());
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetCommentByUserId() {
		Assert.assertFalse(commentService.getCommentsByUserId(1).isEmpty());
		Assert.assertTrue(commentService.getCommentsByUserId(0).isEmpty());
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetCommentByContentId() {
		Assert.assertFalse(commentService.getCommentsByContentId(3).isEmpty());
		Assert.assertTrue(commentService.getCommentsByContentId(0).isEmpty());
	}
}
