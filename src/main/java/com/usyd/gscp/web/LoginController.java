package com.usyd.gscp.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.usyd.gscp.service.UserService;

@Controller
@SessionAttributes("current_user")
public class LoginController {
	
	@Autowired
	private UserService userService; 
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String welcome(Locale locale, Model model) {
		
		return "index";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String login(Locale locale, Model model,
			@RequestParam("account") String account,
			@RequestParam("password") String password) {
		int userID = userService.authenticateUser(account, password);
		if( userID > 0) {
			model.addAttribute("current_user", userService.getUserById(userID));
			return "redirect: /gscp/profile";
		}
		else{
			model.addAttribute("message", "Login failed! Account and password do not match!");
		}
		return "index";
	}
}
