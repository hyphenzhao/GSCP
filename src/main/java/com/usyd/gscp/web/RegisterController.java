package com.usyd.gscp.web;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String welcome(Locale locale, Model model) {
		model.addAttribute("method", "GET");
		return "register";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Locale locale, Model model) {
		return "redirect:/";
	}
}
