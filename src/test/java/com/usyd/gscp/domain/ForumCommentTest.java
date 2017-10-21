package com.usyd.gscp.domain;

import java.util.Date;

import junit.framework.TestCase;

public class ForumCommentTest extends TestCase {
	private ForumComment forumComment;
	protected void setUp() throws Exception {
		forumComment = new ForumComment();
	}
	public void testSetAndGetId(){
		int id = 1;
		forumComment.setId(id);
		assertEquals(forumComment.getId(), id, 0);
	}

	public void testSetAndGetContentId(){
		int contentId = 1;
		forumComment.setContentId(contentId);
		assertEquals(forumComment.getContentId(), contentId, 0);
	}

	public void testSetAndGetUserId(){
		int userId = 1;
		forumComment.setUserId(userId);
		assertEquals(forumComment.getUserId(), userId, 0);
	}

	public void testSetAndGetTitle(){
		String title = "title";
		assertNull(forumComment.getTitle());
		forumComment.setTitle(title);
		assertEquals(forumComment.getTitle(), title);
	}

	public void testSetAndGetContent(){
		String content = "content";
		assertNull(forumComment.getContent());
		forumComment.setContent(content);
		assertEquals(forumComment.getContent(), content);
	}
	
	public void testSetAndGetDate() {
		Date date = new Date();
		assertNull(forumComment.getDate());
		forumComment.setDate(date);
		assertEquals(forumComment.getDate(), date);
	}
	
	public void testSetAndGetVisability() {
		boolean t = true, f = false;
		forumComment.setVisability(t);
		assertEquals(forumComment.isVisability(), t);
		forumComment.setVisability(f);
		assertEquals(forumComment.isVisability(), f);
	}

}
