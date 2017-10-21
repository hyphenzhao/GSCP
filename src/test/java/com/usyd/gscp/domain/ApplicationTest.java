package com.usyd.gscp.domain;

import junit.framework.TestCase;

public class ApplicationTest extends TestCase {
	private Application application;
	
	protected void setUp() throws Exception{
		application = new Application();
	}
	
	public void testSetAndGetId(){
		int id = 1;
		application.setId(id);
		assertEquals(application.getId(), id, 0);
	}

	public void testSetAndGetDegreeId(){
		int degreeId = 1;
		application.setDegreeId(degreeId);
		assertEquals(application.getDegreeId(), degreeId, 0);
	}

	public void testSetAndGetStudentId(){
		int studentId = 1;
		application.setStudentId(studentId);
		assertEquals(application.getStudentId(), studentId, 0);
	}

	public void testSetAndGetAgentId(){
		int agentId = 1;
		application.setAgentId(agentId);
		assertEquals(application.getAgentId(), agentId, 0);
	}

	public void testSetAndGetTitle(){
		String title = "title";
		assertNull(application.getTitle());
		application.setTitle(title);
		assertEquals(application.getTitle(), title);
	}

	public void testSetAndGetContent(){
		String content = "content";
		assertNull(application.getContent());
		application.setContent(content);
		assertEquals(application.getContent(), content);
	}

	public void testSetAndGetStatus(){
		int status = 1;
		application.setStatus(status);
		assertEquals(application.getStatus(), status, 0);
	}

}
