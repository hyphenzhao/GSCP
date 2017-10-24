package com.usyd.gscp.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.gscp.domain.Book;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class BookDaoTest {
	
	@Autowired
	BookDao bookDao;
	
	@Test
    @Transactional
    @Rollback(true)
	public void testSaveBook() {
		Book book = new Book();
		bookDao.saveBook(book);
		int id = book.getId();
		Assert.assertNotEquals(id, 0);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetBookById() {
		Book existBook = bookDao.getBookById(1);
		Book notExBook = bookDao.getBookById(0);
		Assert.assertNotNull(existBook);
		Assert.assertNull(notExBook);
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testGetAllBooks() {
		Assert.assertFalse(bookDao.getAllBooks().isEmpty());
	}
}
