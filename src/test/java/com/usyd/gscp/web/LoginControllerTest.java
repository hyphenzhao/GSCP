package com.usyd.gscp.web;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class LoginControllerTest {
	
	@Autowired
    ApplicationContext applicationContext;
	
	@Autowired
    private LoginController loginController;
	
	private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private HandlerAdapter handlerAdapter;
    
	@Before
    public void setUp() {
       request = new MockHttpServletRequest();
       response = new MockHttpServletResponse();
 
       handlerAdapter = new AnnotationMethodHandlerAdapter();
    }
	
	@Test
	public void testWelcome() throws Exception{
		request.setRequestURI("/index");
        request.setMethod("GET");
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		loginController);
        assertEquals("index", mav.getViewName());
	}
	
	@Test
	public void testLoginSuccessfully() throws Exception{
		request.setRequestURI("/index");
        request.setMethod("POST");
        request.setParameter("account", "hiphon@123.com");
        request.setParameter("password", "123456");
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		loginController);
        assertEquals("redirect: /gscp/profile", mav.getViewName());
	}
	
	@Test
	public void testLoginFailed() throws Exception{
		request.setRequestURI("/index");
        request.setMethod("POST");
        request.setParameter("account", "hiphon@123.com");
        request.setParameter("password", "654321");
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		loginController);
        assertEquals("Login failed! Account and password do not match!",mav.getModel().get("message"));
        assertEquals("index", mav.getViewName());
	}

}
