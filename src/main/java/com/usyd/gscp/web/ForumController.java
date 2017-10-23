package com.usyd.gscp.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usyd.gscp.domain.ForumComment;
import com.usyd.gscp.domain.ForumContent;
import com.usyd.gscp.domain.User;
import com.usyd.gscp.service.ForumCommentService;
import com.usyd.gscp.service.ForumContentService;
import com.usyd.gscp.service.UserService;

@Controller
@SessionAttributes("current_user")
public class ForumController {
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	ForumContentService forumContentService;
	
	@Autowired
	ForumCommentService forumCommentService;
	
	@RequestMapping(value = "/forum/home", method = RequestMethod.GET)
	public String welcome(Locale locale, Model model,
			@ModelAttribute("current_user") User user) {
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
		
		model.addAttribute("current_user", user);
		model.addAttribute("topics", topics);
		model.addAttribute("phrase", "topics");
		
		return "forum-home";
	}
	
	@RequestMapping(value = "/forum/topics", method = RequestMethod.GET)
	public String listMyTopics(Locale locale, Model model,
			@ModelAttribute("current_user") User user) {
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
		
		model.addAttribute("current_user", user);
		model.addAttribute("topics", topics);
		model.addAttribute("phrase", "topics");
		
		return "forum-home";
	}
	
	@RequestMapping(value = "/forum/topics/{topicId}", method = RequestMethod.GET)
	public String getSpecificTopic(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@PathVariable int topicId) {
		ForumContent topic = forumContentService.getCotentById(topicId);
		ArrayList<ForumComment> comments = forumCommentService.getCommentsByContentId(topicId);
		ArrayList<User> users = userService.getAllUsers();
		
		model.addAttribute("topic", topic);
		model.addAttribute("comments", comments);
		model.addAttribute("users", users);
		model.addAttribute("current_user", user);
		
		return "forum-topic";
	}
	
	@RequestMapping(value = "/forum/comments", method = RequestMethod.GET)
	public String listMyComments(Locale locale, Model model,
			@ModelAttribute("current_user") User user) {
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
		
		model.addAttribute("current_user", user);
		model.addAttribute("topics", topics);
		model.addAttribute("phrase", "comments");
		
		return "forum-home";
	}
	
	@RequestMapping(value = "/forum/comments/{commentId}", method = RequestMethod.GET)
	public String getSpecificComments(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@PathVariable int commentId) {
		ForumComment comment = forumCommentService.getCommentById(commentId);
		
		return "redirect: /gscp/forum/topics/" + comment.getContentId();
	}
	
	@RequestMapping(value = "/forum/new/comment", method = RequestMethod.POST)
	public String createNewComment(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("topic") int topicId) {
		ForumComment newComment = new ForumComment();
		
		newComment.setUserId(user.getId());
		newComment.setContentId(topicId);
		newComment.setTitle(title);
		newComment.setContent(content);
		newComment.setVisability(true);
		newComment.setDate(new Date());
		
		forumCommentService.createNewComment(newComment);
		
		return "redirect: /gscp/forum/topics/" + topicId;
	}
	
	@RequestMapping(value = "/forum/new/topic", method = RequestMethod.GET)
	public String newTopicForm(Locale locale, Model model,
			@ModelAttribute("current_user") User user) {
		model.addAttribute("current_user", user);
		
		return "forum-new-topic";
	}
	
	@RequestMapping(value = "/forum/new/topic", method = RequestMethod.POST)
	public String createNewTopic(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@RequestParam("title") String title,
			@RequestParam("content") String content) {
		ForumContent newTopic = new ForumContent();
		
		newTopic.setUserId(user.getId());
		newTopic.setTitle(title);
		newTopic.setContent(content);
		newTopic.setVisability(true);
		newTopic.setDate(new Date());
		
		forumContentService.createNewContent(newTopic);
		
		return "redirect: /gscp/forum/home";
	}
	
	@RequestMapping(value = "/forum/delete/comment", method = RequestMethod.POST)
	public String deleteComment(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@RequestParam("comment") int commentId) {
		ForumComment comment = forumCommentService.getCommentById(commentId);
		
		comment.setVisability(false);
		forumCommentService.updateComment(comment);
		
		return "redirect: /gscp/forum/topics/" + comment.getContentId();
	}
	
	@RequestMapping(value = "/forum/delete/topic", method = RequestMethod.POST)
	public String deleteTopic(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@RequestParam("topic") int topicId) {
		ForumContent content = forumContentService.getCotentById(topicId);
		ArrayList<ForumComment> comments = forumCommentService.getCommentsByContentId(topicId);
		
		content.setVisability(false);
		forumContentService.updateContent(content);
		for(int i = 0; i < comments.size(); i++) {
			ForumComment comment = comments.get(i);
			comment.setVisability(false);
			forumCommentService.updateComment(comment);
		}
		
		return "redirect: /gscp/forum/home";
	}
}
