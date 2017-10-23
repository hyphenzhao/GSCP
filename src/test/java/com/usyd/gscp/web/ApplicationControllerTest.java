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

import com.usyd.gscp.domain.Application;
import com.usyd.gscp.domain.Degree;
import com.usyd.gscp.domain.Document;
import com.usyd.gscp.domain.University;
import com.usyd.gscp.domain.User;
import com.usyd.gscp.service.ApplicationService;
import com.usyd.gscp.service.ApplicationStatusContext;
import com.usyd.gscp.service.DegreeService;
import com.usyd.gscp.service.DocumentService;
import com.usyd.gscp.service.UniversityService;
import com.usyd.gscp.service.UserRoleContext;
import com.usyd.gscp.service.UserService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class ApplicationControllerTest {

	@Autowired
    ApplicationContext applicationContext;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private UniversityService uniService;
	
	@Autowired
	private DegreeService degreeService;
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private DocumentService documentService;
     
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private HandlerAdapter handlerAdapter; 
     
    @Autowired
    private ApplicationController applicationController;
     
    @Before
    public void setUp() {
       request = new MockHttpServletRequest();
       response = new MockHttpServletResponse();
 
       handlerAdapter = new AnnotationMethodHandlerAdapter();
    }
     
    @Test
    public void testWelcome() throws Exception {
    	User user = userService.getUserById(1); 
        request.setRequestURI("/application/home");
        request.setMethod("GET");
        request.getSession().setAttribute("current_user", user);
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		applicationController);
        
        assertEquals(user.getFirst(), mav.getModel().get("user_first"));
        assertEquals(user.getLast(), mav.getModel().get("user_last"));
        assertEquals(user.getEmail(), mav.getModel().get("user_email"));
        assertEquals(user.getPhone(), mav.getModel().get("user_phone"));
        assertEquals("application-home", mav.getViewName());
        
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testRegister() throws Exception {
    	User user = new User();
    	user.setFirst("first");
    	user.setEmail("email");
    	user.setLast("last");
    	user.setPassword("password");
    	user.setPhone("phone");
    	user.setPhoto("photo");
    	user.setRole(0);
    	user.setUsername("username");
        request.setRequestURI("/application/home");
        request.setMethod("POST");
        request.getSession().setAttribute("current_user", user);
        request.addParameter("new_role", "student");
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		applicationController);
        
        assertEquals(user.getFirst(), mav.getModel().get("user_first"));
        assertEquals(user.getLast(), mav.getModel().get("user_last"));
        assertEquals(user.getEmail(), mav.getModel().get("user_email"));
        assertEquals(user.getPhone(), mav.getModel().get("user_phone"));
        assertEquals("application-home", mav.getViewName());
    }
    
    @Test
    public void testNewApplicationView() throws Exception{
    	ArrayList<University> unis = uniService.getAllUnis();
		ArrayList<Degree> degrees = degreeService.getAllDegrees();
		ArrayList<User> agents = userService.getUsersByRole(UserRoleContext.USER_AGENT);
		
		request.setRequestURI("/application/student/new");
        request.setMethod("GET");
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		applicationController);
        
        assertEquals(unis.size(), ((ArrayList<University>)mav.getModel().get("universities")).size());
        assertEquals(degrees.size(),((ArrayList<Degree>) mav.getModel().get("degrees")).size());
        assertEquals(agents.size(), ((ArrayList<User>)mav.getModel().get("agents")).size());
        assertEquals("application-student-new", mav.getViewName());
    }
    
    @Test
    public void testHistoryApplicationView() throws Exception{
    	User user = userService.getUserById(1); 
    	request.setRequestURI("/application/student/history");
        request.setMethod("GET");
        request.getSession().setAttribute("current_user", user);
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		applicationController);
        
        ArrayList<Application> currentApplications = applicationService.getApplicationByStudentId(user.getId());
		ArrayList<University> unis = uniService.getAllUnis();
		ArrayList<Degree> degrees = degreeService.getAllDegrees();
		ArrayList<User> agents = userService.getUsersByRole(UserRoleContext.USER_AGENT);
		
		Collections.sort(currentApplications, new Comparator<Application>() {
	        @Override
	        public int compare(Application app1, Application app2)
	        {
	        	int result = -1;
	        	if(app1.getId() < app2.getId()){
	        		result = 1;
	        	}
	            return  result;
	        }
	    });
		
		assertEquals("list", mav.getModel().get("type"));
		assertEquals(currentApplications.size(), ((ArrayList<University>)mav.getModel().get("applications")).size());
		assertEquals(unis.size(), ((ArrayList<University>)mav.getModel().get("universities")).size());
	    assertEquals(degrees.size(),((ArrayList<Degree>) mav.getModel().get("degrees")).size());
	    assertEquals(agents.size(), ((ArrayList<User>)mav.getModel().get("agents")).size());
		assertEquals("application-student-history", mav.getViewName());
    }
    
    @Test
    public void testHistoryApplicationDetail() throws Exception{
    	User user = userService.getUserById(1); 
    	request.setRequestURI("/application/student/history/1");
        request.setMethod("GET");
        request.getSession().setAttribute("current_user", user);
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		applicationController);
        ArrayList<Application> currentApplications = applicationService.getApplicationByStudentId(user.getId());
		if(currentApplications.size() == 0) {
			assertEquals("redirect: /gscp/application/student/new", mav.getViewName());
			return ;
		}
		Collections.sort(currentApplications, new Comparator<Application>() {
	        @Override
	        public int compare(Application app1, Application app2)
	        {
	        	int result = -1;
	        	if(app1.getId() < app2.getId()){
	        		result = 1;
	        	}
	            return  result;
	        }
	    });
		
		Application cApplication = currentApplications.get(0);
		Degree cDegree = degreeService.getDegreeById(cApplication.getDegreeId());
		University cUniversity = uniService.getUniById(cDegree.getUniId());
		ArrayList<Document> cDocuments = documentService.getDocumentsByAppId(cApplication.getId());
		
		assertEquals("details", mav.getModel().get("type"));
		assertEquals(cApplication.getId(), ((Application)mav.getModel().get("application")).getId());
		assertEquals(cDegree.getId(), ((Degree)mav.getModel().get("degree")).getId());
		assertEquals(cUniversity.getId(), ((University)mav.getModel().get("university")).getId());
		assertEquals(cDocuments.size(), ((ArrayList<Document>)mav.getModel().get("documents")).size());
		assertEquals("application-student-history", mav.getViewName());
    }
    
    @Test
    public void testStudentApplicationDetailUpdate() throws Exception{
    	User user = userService.getUserById(1); 
    	request.setRequestURI("/application/student/history");
        request.setMethod("POST");
        request.getSession().setAttribute("current_user", user);
        request.addParameter("title", "title");
        request.addParameter("content", "content");
        request.addParameter("application-id", "16");
        
       ModelAndView mav = handlerAdapter.handle(request, response, 
    		   applicationController);
       assertEquals("redirect: /gscp/application/student/history", mav.getViewName());
    }
    
    @Test
    public void testAgentApplicationDetail() throws Exception{
    	User user = userService.getUserById(2); 
    	request.setRequestURI("/application/agent/1");
        request.setMethod("GET");
        request.getSession().setAttribute("current_user", user);
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		applicationController);
        ArrayList<Application> currentApplications = applicationService.getApplicationByAgentId(user.getId());
		if(currentApplications.size() == 0) {
			assertEquals("redirect: /gscp/application/home", mav.getViewName());
			return ;
		}
		Collections.sort(currentApplications, new Comparator<Application>() {
	        @Override
	        public int compare(Application app1, Application app2)
	        {
	        	int result = -1;
	        	if(app1.getId() < app2.getId()){
	        		result = 1;
	        	}
	            return  result;
	        }
	    });
		
		Application cApplication = currentApplications.get(0);
		Degree cDegree = degreeService.getDegreeById(cApplication.getDegreeId());
		University cUniversity = uniService.getUniById(cDegree.getUniId());
		ArrayList<Document> cDocuments = documentService.getDocumentsByAppId(cApplication.getId());
		
		assertEquals("details", mav.getModel().get("type"));
		assertEquals(cApplication.getId(), ((Application)mav.getModel().get("application")).getId());
		assertEquals(cDegree.getId(), ((Degree)mav.getModel().get("degree")).getId());
		assertEquals(cUniversity.getId(), ((University)mav.getModel().get("university")).getId());
		assertEquals(cDocuments.size(), ((ArrayList<Document>)mav.getModel().get("documents")).size());
		assertEquals("application-agent", mav.getViewName());
    }
    
    @Test
    public void testAgentApplicationDetailUpdate() throws Exception{
    	User user = userService.getUserById(2); 
    	request.setRequestURI("/application/agent");
        request.setMethod("POST");
        request.getSession().setAttribute("current_user", user);
        request.addParameter("title", "title");
        request.addParameter("content", "content");
        request.addParameter("application-id", "16");
        request.addParameter("status", "1");
        
       ModelAndView mav = handlerAdapter.handle(request, response, 
    		   applicationController);
       assertEquals("redirect: /gscp/application/agent", mav.getViewName());
    }
}
