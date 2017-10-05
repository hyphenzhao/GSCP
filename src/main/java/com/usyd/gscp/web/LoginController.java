package com.usyd.gscp.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.usyd.gscp.service.UserService;

@Controller
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
		if(userService.authenticateUser(account, password))
			model.addAttribute("message", "Login successfully!");
		else
			model.addAttribute("message", "Login failed!");
		return "home";
	}
}
