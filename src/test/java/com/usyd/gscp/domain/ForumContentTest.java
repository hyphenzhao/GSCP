package com.usyd.gscp.domain;

import java.util.Date;

import junit.framework.TestCase;

public class ForumContentTest extends TestCase {
	private ForumContent forumContent;
	protected void setUp() throws Exception {
		forumContent = new ForumContent();
	}
	public void testSetAndGetId(){
		int id = 1;
		forumContent.setId(id);
		assertEquals(forumContent.getId(), id, 0);
	}

	public void testSetAndGetUserId(){
		int userId = 1;
		forumContent.setUserId(userId);
		assertEquals(forumContent.getUserId(), userId, 0);
	}

	public void testSetAndGetTitle(){
		String title = "title";
		assertNull(forumContent.getTitle());
		forumContent.setTitle(title);
		assertEquals(forumContent.getTitle(), title);
	}

	public void testSetAndGetContent(){
		String content = "content";
		assertNull(forumContent.getContent());
		forumContent.setContent(content);
		assertEquals(forumContent.getContent(), content);
	}

	public void testSetAndGetDate() {
		Date date = new Date();
		assertNull(forumContent.getDate());
		forumContent.setDate(date);
		assertEquals(forumContent.getDate(), date);
	}
	
	public void testSetAndGetVisability() {
		boolean t = true, f = false;
		forumContent.setVisability(t);
		assertEquals(forumContent.isVisability(), t);
		forumContent.setVisability(f);
		assertEquals(forumContent.isVisability(), f);
	}
}