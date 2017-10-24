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
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class HouseControllerTest {
  @Autowired
     ApplicationContext applicationContext;
     private MockHttpServletRequest request;
     private MockHttpServletResponse response;
     private HandlerAdapter handlerAdapter; 
  @Autowired
   private HouseController houseController;
   
  @Before
     public void setUp() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
  
        handlerAdapter = new AnnotationMethodHandlerAdapter();
     }
  @Test
     public void testWelcome() throws Exception {
      request.setRequestURI("/accommodation/home");
         request.setMethod("GET");
         ModelAndView mav = handlerAdapter.handle(request, response, 
           houseController);
         assertEquals("house-home", mav.getViewName());
     }
}