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

import com.usyd.gscp.domain.ForumComment;
import com.usyd.gscp.domain.ForumContent;
import com.usyd.gscp.domain.User;
import com.usyd.gscp.service.ForumCommentService;
import com.usyd.gscp.service.ForumContentService;
import com.usyd.gscp.service.UserService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/hibernate-context.xml"})
public class ForumControllerTest { 
	
	@Autowired
	ForumContentService forumContentService;
	
	@Autowired
	ForumCommentService forumCommentService;
	
	@Autowired
    ApplicationContext applicationContext;
	
	@Autowired
	ForumController forumController;
	
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
    @Transactional
    @Rollback(true)
    public void testWelcome() throws Exception{
    	User user = userService.getUserById(1); 
        request.setRequestURI("/forum/home");
        request.setMethod("GET");
        request.getSession().setAttribute("current_user", user);
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		forumController);
        
        ArrayList<ForumContent> topics = forumContentService.getAllCotents();
        Collections.sort(topics, new Comparator<ForumContent>() {
	        @Override
	        public int compare(ForumContent content1, ForumContent content2)
	        {
	        	int result = -1;
	        	if(content1.getId() < content2.getId()){
	        		result = 1;
	        	}
	            return  result;
	        }
	    });
        assertEquals(user.getId(),((User)mav.getModel().get("current_user")).getId());
        assertEquals(topics.size(), ((ArrayList<ForumContent>)mav.getModel().get("topics")).size());
        assertEquals("topics", mav.getModel().get("phrase"));
        assertEquals("forum-home", mav.getViewName());
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testListMyTopics() throws Exception{
    	User user = userService.getUserById(1); 
        request.setRequestURI("/forum/topics");
        request.setMethod("GET");
        request.getSession().setAttribute("current_user", user);
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		forumController);
        
        ArrayList<ForumContent> topics = forumContentService.getCotentByUserId(user.getId());
		
		Collections.sort(topics, new Comparator<ForumContent>() {
	        @Override
	        public int compare(ForumContent content1, ForumContent content2)
	        {
	        	int result = -1;
	        	if(content1.getId() < content2.getId()){
	        		result = 1;
	        	}
	            return  result;
	        }
	    });
		
		assertEquals(user.getId(),((User)mav.getModel().get("current_user")).getId());
		assertEquals(topics.size(), ((ArrayList<ForumContent>)mav.getModel().get("topics")).size());
        assertEquals("topics", mav.getModel().get("phrase"));
        assertEquals("forum-home", mav.getViewName());
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testGetSpecificTopic() throws Exception{
    	User user = userService.getUserById(1); 
        request.setRequestURI("/forum/topics/2");
        request.setMethod("GET");
        request.getSession().setAttribute("current_user", user);
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		forumController);
        
        ForumContent topic = forumContentService.getCotentById(2);
		ArrayList<ForumComment> comments = forumCommentService.getCommentsByContentId(2);
		ArrayList<User> users = userService.getAllUsers();
		
		assertEquals(user.getId(),((User)mav.getModel().get("current_user")).getId());
		assertEquals(topic.getId(),((ForumContent)mav.getModel().get("topic")).getId());
		assertEquals(comments.size(), ((ArrayList<ForumComment>)mav.getModel().get("comments")).size());
        assertEquals(users.size(), ((ArrayList<User>)mav.getModel().get("users")).size());
        assertEquals("forum-topic", mav.getViewName());
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testListMyComments() throws Exception{
    	User user = userService.getUserById(1); 
        request.setRequestURI("/forum/comments");
        request.setMethod("GET");
        request.getSession().setAttribute("current_user", user);
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		forumController);
        
        ArrayList<ForumComment> topics = forumCommentService.getCommentsByUserId(user.getId());
		
		Collections.sort(topics, new Comparator<ForumComment>() {
	        @Override
	        public int compare(ForumComment content1, ForumComment content2)
	        {
	        	int result = -1;
	        	if(content1.getId() < content2.getId()){
	        		result = 1;
	        	}
	            return  result;
	        }
	    });
		
		assertEquals(user.getId(),((User)mav.getModel().get("current_user")).getId());
		assertEquals(topics.size(), ((ArrayList<ForumComment>)mav.getModel().get("topics")).size());
        assertEquals("comments", mav.getModel().get("phrase"));
        assertEquals("forum-home", mav.getViewName());
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testGetSpecificComments() throws Exception{
    	User user = userService.getUserById(1); 
        request.setRequestURI("/forum/comments/2");
        request.setMethod("GET");
        request.getSession().setAttribute("current_user", user);
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		forumController);
        
        ForumComment comment = forumCommentService.getCommentById(2);
        assertEquals("redirect: /gscp/forum/topics/" + comment.getContentId(), mav.getViewName());
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testCreateNewComment() throws Exception{
    	User user = userService.getUserById(1); 
        request.setRequestURI("/forum/new/comment");
        request.setMethod("POST");
        request.getSession().setAttribute("current_user", user);
        request.addParameter("title", "title");
        request.addParameter("content", "content");
        request.addParameter("topic", "2");
        
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		forumController);
        
        assertEquals("redirect: /gscp/forum/topics/2", mav.getViewName());
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testNewTopicForm() throws Exception{
    	User user = userService.getUserById(1); 
        request.setRequestURI("/forum/new/topic");
        request.setMethod("GET");
        request.getSession().setAttribute("current_user", user);
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		forumController);
        
        assertEquals("forum-new-topic", mav.getViewName());
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testCreateNewTopic() throws Exception{
    	User user = userService.getUserById(1); 
        request.setRequestURI("/forum/new/topic");
        request.setMethod("POST");
        request.getSession().setAttribute("current_user", user);
        request.addParameter("title", "title");
        request.addParameter("content", "content");
        
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		forumController);
        
        assertEquals("redirect: /gscp/forum/home", mav.getViewName());
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteComment() throws Exception{
    	User user = userService.getUserById(1); 
        request.setRequestURI("/forum/delete/comment");
        request.setMethod("POST");
        request.getSession().setAttribute("current_user", user);
        request.addParameter("comment", "10");
        ForumComment comment = forumCommentService.getCommentById(10);
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		forumController);
        
        assertEquals("redirect: /gscp/forum/topics/"  + comment.getContentId(), mav.getViewName());
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteTopic() throws Exception{
    	User user = userService.getUserById(1); 
        request.setRequestURI("/forum/delete/topic");
        request.setMethod("POST");
        request.getSession().setAttribute("current_user", user);
        request.addParameter("topic", "2");
        
        
        ModelAndView mav = handlerAdapter.handle(request, response, 
        		forumController);
        
        assertEquals("redirect: /gscp/forum/home", mav.getViewName());
    }
}
