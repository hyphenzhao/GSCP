package com.usyd.gscp.domain;

import junit.framework.TestCase;

public class BookTest extends TestCase {
	private Book book;
	
	protected void setUp() throws Exception{
		book = new Book();
	}
	
	public void testSetAndGetId(){
		int id = 1;
		book.setId(id);
		assertEquals(book.getId(), id, 0);
	}

	public void testSetAndGetEdition(){
		int edition = 1;
		book.setEdition(edition);
		assertEquals(book.getEdition(), edition, 0);
	}
	
	public void testSetAndGetYear(){
		int year = 2000;
		book.setYear(year);
		assertEquals(book.getYear(), year, 0);
	}
	
	public void testSetAndGetPrice(){
		int price = 100;
		book.setPrice(price);
		assertEquals(book.getPrice(), price, 0);
	}
	
	public void testSetAndGetOwner(){
		int owner = 1;
		book.setOwner(owner);
		assertEquals(book.getOwner(), owner, 0);
	}

	public void testSetAndGetAuthor(){
		String author = "author";
		assertNull(book.getAuthor());
		book.setAuthor(author);
		assertEquals(book.getAuthor(), author);
	}

	public void testSetAndGetSubject(){
		String subject = "subject";
		assertNull(book.getSubject());
		book.setSubject(subject);
		assertEquals(book.getSubject(), subject);
	}
	
	public void testSetAndGetTitle(){
		String title = "title";
		assertNull(book.getTitle());
		book.setTitle(title);
		assertEquals(book.getTitle(), title);
	}
	
	public void testSetAndGetStatus(){
		String status = "status";
		assertNull(book.getStatus());
		book.setStatus(status);
		assertEquals(book.getStatus(), status);
	}

}