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

import com.usyd.gscp.service.UserService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class RegisterControllerTest {
	@Autowired
    ApplicationContext applicationContext;
	
	@Autowired
	RegisterController registerController;
	
	@Autowired
	UserService userService;
	
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
    public void testWelcome() throws Exception {
    	request.setRequestURI("/register");
        request.setMethod("GET");
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		registerController);
        assertEquals("register", mav.getViewName());
    }
    
    @Test
    public void testRegister() throws Exception {
    	request.setRequestURI("/register");
        request.setMethod("POST");
        request.addParameter("username", "username");
        request.addParameter("password", "password");
        request.addParameter("email", "email");
        request.addParameter("firstname", "firstname");
        request.addParameter("lastname", "lastname");
        request.addParameter("phone", "phone");
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		registerController);
        assertEquals("redirect:/index", mav.getViewName());
    }
}
