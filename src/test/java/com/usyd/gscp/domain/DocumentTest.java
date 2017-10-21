package com.usyd.gscp.domain;

import junit.framework.TestCase;

public class DocumentTest extends TestCase {
	private Document document;
	protected void setUp() throws Exception {
		document = new Document();
	}
	public void testSetAndGetId(){
		int id = 1;
		document.setId(id);
		assertEquals(document.getId(), id, 0);
	}

	public void testSetAndGetName(){
		String name = "name";
		assertNull(document.getName());
		document.setName(name);
		assertEquals(document.getName(), name);
	}

	public void testSetAndGetPath(){
		String path = "path";
		assertNull(document.getPath());
		document.setPath(path);
		assertEquals(document.getPath(), path);
	}

	public void testSetAndGetApplicationId(){
		int applicationId = 1;
		document.setApplicationId(applicationId);
		assertEquals(document.getApplicationId(), applicationId, 0);
	}

}
