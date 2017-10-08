package com.usyd.gscp.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.usyd.gscp.domain.User;
import com.usyd.gscp.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userSevice; 
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String welcome(Locale locale, Model model) {
		return "register";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Locale locale, Model model,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("phone") String phone) {
		
		User newUser = new User();
		
		newUser.setUsername(username);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setFirst(firstname);
		newUser.setLast(lastname);
		newUser.setPhone(phone);
		
		userSevice.registerUser(newUser);
		
		return "redirect:/profile";
	}
}
