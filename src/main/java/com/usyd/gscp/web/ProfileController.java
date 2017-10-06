package com.usyd.gscp.web;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.usyd.gscp.domain.User;
import com.usyd.gscp.service.UserRoleContext;

@Controller
@SessionAttributes("current_user")
public class ProfileController {
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String welcome(Locale locale, Model model,
			@ModelAttribute("current_user") User user) {
		String userRole = "";
		if (((user.getRole() & UserRoleContext.USER_STUDENT) == 0)) {
			userRole += "Student ";
		}
		if (((user.getRole() & UserRoleContext.USER_AGENT) == 0)) {
			userRole += "Agent ";
		}
		if (((user.getRole() & UserRoleContext.USER_BUYER) == 0)) {
			userRole += "Buyer ";
		}
		if (((user.getRole() & UserRoleContext.USER_SELLER) == 0)) {
			userRole += "Seller ";
		}
		if (((user.getRole() & UserRoleContext.USER_LANDLOAD) == 0)) {
			userRole += "Landlord ";
		}
		if (((user.getRole() & UserRoleContext.USER_RENTER) == 0)) {
			userRole += "Renter ";
		}
		
		model.addAttribute("user_first", user.getFirst());
		model.addAttribute("user_last", user.getLast());
		model.addAttribute("user_email", user.getEmail());
		model.addAttribute("user_phone", user.getPhone());
		model.addAttribute("user_role", userRole);
		
		return "profile";
	}
}
