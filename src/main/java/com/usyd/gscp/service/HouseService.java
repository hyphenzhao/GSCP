package com.usyd.gscp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.gscp.dao.HouseDao;
import com.usyd.gscp.domain.House;

@Service(value = "houseService")
@Transactional
public class HouseService {
	@Autowired
	private HouseDao houseDao;
	
	public House getHouseById(int id){
		return houseDao.getHouseById(id);
	}
	public House getHouseById(String id){
		return houseDao.getHouseById(Integer.parseInt(id));
	}
	public ArrayList<House> getAllHouses(){
		ArrayList<House> result = (ArrayList<House>)houseDao.getAllHouses();
		return result;
	}
	
}
