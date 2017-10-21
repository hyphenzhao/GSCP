package com.usyd.gscp.domain;

import junit.framework.TestCase;

public class UniversityTest extends TestCase {
	private University university;
	protected void setUp() throws Exception {
		university = new University();
	}
	public void testSetAndGetId(){
		int id = 1;
		university.setId(id);
		assertEquals(university.getId(), id, 0);
	}

	public void testSetAndGetName(){
		String name = "name";
		assertNull(university.getName());
		university.setName(name);
		assertEquals(university.getName(), name);
	}

	public void testSetAndGetDescription(){
		String description = "description";
		assertNull(university.getDescription());
		university.setDescription(description);
		assertEquals(university.getDescription(), description);
	}

	public void testSetAndGetImage(){
		String image = "image";
		assertNull(university.getImage());
		university.setImage(image);
		assertEquals(university.getImage(), image);
	}

	public void testSetAndGetUrl(){
		String url = "url";
		assertNull(university.getUrl());
		university.setUrl(url);
		assertEquals(university.getUrl(), url);
	}

}
