package com.usyd.gscp.web;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import com.usyd.gscp.domain.User;
import com.usyd.gscp.domain.Book;
import com.usyd.gscp.domain.Orders;

import com.usyd.gscp.service.UserService;
import com.usyd.gscp.service.BookService;
import com.usyd.gscp.service.OrdersService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class BookControllerTest {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private BookService bookService;
     
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private HandlerAdapter handlerAdapter; 
     
    @Autowired
    private BookController bookController;
     
    @Before
    public void setUp() {
       request = new MockHttpServletRequest();
       response = new MockHttpServletResponse();
 
       handlerAdapter = new AnnotationMethodHandlerAdapter();
    }
     
    @Test
    public void testWelcome() throws Exception {
    	User user = userService.getUserById(1); 
        request.setRequestURI("/trading/home");
        request.setMethod("GET");
        request.getSession().setAttribute("current_user", user);
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		bookController);
        
        assertEquals(user.getFirst(), mav.getModel().get("user_first"));
        assertEquals(user.getLast(), mav.getModel().get("user_last"));
        assertEquals(user.getEmail(), mav.getModel().get("user_email"));
        assertEquals(user.getPhone(), mav.getModel().get("user_phone"));
        assertEquals("trading-home", mav.getViewName());
        
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testNewTopicForm() throws Exception{
    	User user = userService.getUserById(1); 
        request.setRequestURI("/trading/new_post");
        request.setMethod("GET");
        request.getSession().setAttribute("current_user", user);
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		bookController);
        
        assertEquals("trading-new-post", mav.getViewName());
    }
}