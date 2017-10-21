package com.usyd.gscp.domain;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	private User user;
	
	protected void setUp() throws Exception{
		user = new User();
	}
	
	public void testSetAndGetId() {
		int id = 1;
		user.setId(id);
		assertEquals(user.getId(), id, 0);
	}
	
	public void testSetAndGetUsername() {
		String username = "username";
		assertNull(user.getUsername());
		user.setUsername(username);
		assertEquals(user.getUsername(), username);
	}
	
	public void testSetAndGetPassword() {
		String password = "password";
		assertNull(user.getPassword());
		user.setPassword(password);
		assertEquals(user.getPassword(), password);
	}
	
	public void testSetAndGetFirst() {
		String first = "first";
		assertNull(user.getFirst());
		user.setFirst(first);
		assertEquals(user.getFirst(), first);
	}
	
	public void testSetAndGetLast() {
		String last = "last";
		assertNull(user.getLast());
		user.setLast(last);
		assertEquals(user.getLast(), last);
	}
	
	public void testSetAndGetEmail(){
		String email = "email";
		assertNull(user.getEmail());
		user.setEmail(email);
		assertEquals(user.getEmail(), email);
	}
	
	public void testSetAndGetRole(){
		int role = 1;
		user.setRole(role);
		assertEquals(user.getRole(), role, 0);
	}
	public void testSetAndGetPhone(){
		String phone = "phone";
		assertNull(user.getPhone());
		user.setPhone(phone);
		assertEquals(user.getPhone(), phone);
	}
	public void testSetAndGetPhoto(){
		String photo = "photo";
		assertNull(user.getPhoto());
		user.setPhoto(photo);
		assertEquals(user.getPhoto(), photo);
	}
}
