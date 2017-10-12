package com.usyd.gscp.web;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.usyd.gscp.domain.House;
import com.usyd.gscp.domain.University;
import com.usyd.gscp.domain.User;
import com.usyd.gscp.service.HouseService;
import com.usyd.gscp.service.UserRoleContext;
import com.usyd.gscp.service.UserService;

@Controller
@SessionAttributes("current_user")
public class HouseController {
	@Autowired
	private HouseService houseService;
	
	@RequestMapping(value="/accommodation/home",method = RequestMethod.GET)
	public String Welcome(Locale locale, Model model,
			@ModelAttribute("current_user") User user) {
		ArrayList<House> houses = houseService.getAllHouses();
		
		
		model.addAttribute("houses", houses);
		
		return "house-home";
	}
}
