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

import com.usyd.gscp.domain.User;
import com.usyd.gscp.service.UserService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class ProfileControllerTest {

	@Autowired
    ApplicationContext applicationContext;
	
	@Autowired
	ProfileController profileController;
	
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
    	User user = userService.getUserById(1); 
        request.setRequestURI("/profile");
        request.setMethod("GET");
        request.getSession().setAttribute("current_user", user);
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		profileController);
        
        assertEquals(user.getFirst(), mav.getModel().get("user_first"));
        assertEquals(user.getLast(), mav.getModel().get("user_last"));
        assertEquals(user.getEmail(), mav.getModel().get("user_email"));
        assertEquals(user.getPhone(), mav.getModel().get("user_phone"));
        assertEquals("profile", mav.getViewName());
    }
	
}
