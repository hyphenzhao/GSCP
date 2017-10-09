package com.usyd.gscp.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

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

@Controller
@SessionAttributes("current_user")
public class ApplicationController {
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private UniversityService uniService;
	
	@Autowired
	private DegreeService degreeService;
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private DocumentService documentService;
	
	@RequestMapping(value = "/application/home", method = RequestMethod.GET)
	public String welcome(Locale locale, Model model,
			@ModelAttribute("current_user") User user) {
		
		if(((user.getRole() & UserRoleContext.USER_STUDENT) == 0) && ((user.getRole() & UserRoleContext.USER_AGENT) == 0)) {
			model.addAttribute("user_role", "none");
		} else if (((user.getRole() & UserRoleContext.USER_STUDENT) == 0)) {
			model.addAttribute("user_role", "agent");
		} else if (((user.getRole() & UserRoleContext.USER_AGENT) == 0)){
			model.addAttribute("user_role", "student");
		}
		model.addAttribute("user_first", user.getFirst());
		model.addAttribute("user_last", user.getLast());
		model.addAttribute("user_email", user.getEmail());
		model.addAttribute("user_phone", user.getPhone());
		
		return "application-home";
	}
	
	@RequestMapping(value = "/application/home", method = RequestMethod.POST)
	public String register(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@RequestParam("new_role")String newRoleString) {
		int newRoleInt = user.getRole();
		if(newRoleString.equals("student")) {
			newRoleInt |= UserRoleContext.USER_STUDENT;
			model.addAttribute("user_role", "student");
		} else {
			newRoleInt |= UserRoleContext.USER_AGENT;
			model.addAttribute("user_role", "agent");
		}
		user.setRole(newRoleInt);
		userService.updateUser(user);
		
		model.addAttribute("user_first", user.getFirst());
		model.addAttribute("user_last", user.getLast());
		model.addAttribute("user_email", user.getEmail());
		model.addAttribute("user_phone", user.getPhone());
		
		return "application-home";
	}
	
	@RequestMapping(value = "/application/student/new", method = RequestMethod.GET)
	public String newApplicaitionView(Locale locale, Model model) {
		ArrayList<University> unis = uniService.getAllUnis();
		ArrayList<Degree> degrees = degreeService.getAllDegrees();
		ArrayList<User> agents = userService.getUsersByRole(UserRoleContext.USER_AGENT);
		
		model.addAttribute("universities", unis);
		model.addAttribute("degrees", degrees);
		model.addAttribute("agents", agents);
		
		return "application-student-new";
	}
	
	@RequestMapping(value = "/application/student/new", method = RequestMethod.POST)
	public String newApplicationSubmit(Locale locale, Model model,
			@RequestParam("university") String uniId, 
			@RequestParam("degree") String degreeId,
			@RequestParam("agent") String agentId,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@ModelAttribute("current_user") User user,
			@RequestParam("file") MultipartFile file) {
		Application newApplication = new Application();
		
		newApplication.setDegreeId(Integer.parseInt(degreeId));
		newApplication.setAgentId(Integer.parseInt(agentId));
		newApplication.setStudentId(user.getId());
		newApplication.setTitle(title);
		newApplication.setContent(content);
		newApplication.setStatus(ApplicationStatusContext.STATUS_SUBMITTED);
		
		applicationService.uploadApplication(newApplication);
		
		Document newDocument = new Document();
		String orgName = file.getOriginalFilename();
		
		newDocument.setApplicationId(newApplication.getId());
		newDocument.setName(orgName);
		
		documentService.createDocument(newDocument, file);
		
		return "redirect: /gscp/profile";
	}
}
