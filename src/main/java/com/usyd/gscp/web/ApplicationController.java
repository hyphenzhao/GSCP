package com.usyd.gscp.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.usyd.gscp.domain.User;
import com.usyd.gscp.service.UserRoleContext;
import com.usyd.gscp.service.UserService;

@Controller
@SessionAttributes("current_user")
public class ApplicationController {
	
	@Autowired
	private UserService userService; 
	
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
	public String newApplicaitionView() {
		return "application-student-new";
	}
}
