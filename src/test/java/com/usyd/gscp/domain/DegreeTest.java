package com.usyd.gscp.domain;

import junit.framework.TestCase;

public class DegreeTest extends TestCase {
	private Degree degree;
	
	protected void setUp() throws Exception{
		degree = new Degree();
	}
	
	public void testSetAndGetId(){
		int id = 1;
		degree.setId(id);
		assertEquals(degree.getId(), id, 0);
	}

	public void testSetAndGetUniId(){
		int uniId = 1;
		degree.setUniId(uniId);
		assertEquals(degree.getUniId(), uniId, 0);
	}

	public void testSetAndGetName(){
		String name = "name";
		assertNull(degree.getName());
		degree.setName(name);
		assertEquals(degree.getName(), name);
	}

	public void testSetAndGetDescription(){
		String description = "description";
		assertNull(degree.getDescription());
		degree.setDescription(description);
		assertEquals(degree.getDescription(), description);
	}

}
