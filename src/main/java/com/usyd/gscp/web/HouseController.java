package com.usyd.gscp.web;

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

import com.usyd.gscp.domain.House;
import com.usyd.gscp.domain.User;
import com.usyd.gscp.service.HouseService;

@Controller
@SessionAttributes("current_user")
public class HouseController {
	@Autowired
	private HouseService houseService;
	
	@RequestMapping(value="/accommodation/home",method = RequestMethod.GET)
	public String Welcome(Locale locale, Model model,
			@ModelAttribute("current_user") User user) {
		
		ArrayList<House> houses = houseService.getAllHouses();
		ArrayList<House> apartmentHouse = houseService.getHouseByType("apartment");
		ArrayList<House> houseHouse = houseService.getHouseByType("house");
		ArrayList<House> unitHouse = houseService.getHouseByType("unit");
		
		ArrayList<House> house0 = houseService.getHouseByPrice(0);
		ArrayList<House> house2 = houseService.getHouseByPrice(200);
		ArrayList<House> house4 = houseService.getHouseByPrice(400);
		ArrayList<House> house6 = houseService.getHouseByPrice(600);
		
		ArrayList<House> houseBed1 = houseService.getHouseByBed(1);
		ArrayList<House> houseBed2 = houseService.getHouseByBed(2);
		ArrayList<House> houseBed3 = houseService.getHouseByBed(3);
		
		
		model.addAttribute("user_first", user.getFirst());
		model.addAttribute("houses", houses);
		model.addAttribute("apartmentHouse", apartmentHouse);
		model.addAttribute("houseHouse", houseHouse);
		model.addAttribute("unitHouse", unitHouse);
		model.addAttribute("house0", house0);
		model.addAttribute("house2", house2);
		model.addAttribute("house4", house4);
		model.addAttribute("house6", house6);
		model.addAttribute("houseBed1", houseBed1);
		model.addAttribute("houseBed2", houseBed2);
		model.addAttribute("houseBed3", houseBed3);
		return "house-home";
	}
	
	@RequestMapping(value="/accommodation/home",method = RequestMethod.POST)
	public String Search(Locale locale, Model model,
			@RequestParam("suburb") String suburb,
			@ModelAttribute("current_user") User user){
		System.out.println(suburb);
		System.out.println(user.getFirst());
		return "house-home";
	}
}
