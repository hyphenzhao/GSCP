package com.usyd.gscp.service;

import java.security.MessageDigest;
import java.util.ArrayList;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.gscp.dao.UserDao;
import com.usyd.gscp.domain.User;

@Service(value = "userService")
@Transactional
public class UserService {
	
    @Autowired
    private UserDao userDao;
    
    public ArrayList<User> getAllUsers() {
    	ArrayList<User> result = (ArrayList<User>)userDao.getAllUsers();
    	return result;
    }
    
    public User getUserById(int id) {
    	return userDao.getUserById(id);
    }
    
    public User getUserById(String id) {
    	return userDao.getUserById(Integer.parseInt(id));
    }
    
    public ArrayList<User> getUsersByRole(int role) {
    	ArrayList<User> result = new ArrayList<User>();
    	ArrayList<User> allUsers = (ArrayList<User>) userDao.getAllUsers();
    	
    	for(int i = 0; i < allUsers.size(); i++) {
    		if((allUsers.get(i).getRole() & role) != 0) {
    			result.add(allUsers.get(i));
    		}
    	}
    	
    	return result;
    }
    
    public int authenticateUser(String account, String password) {
    	return userDao.checkLogin(account, hashCode(password));
    }
    
    public void registerUser(User user) {
    	user.setPassword(
    			hashCode(user.getPassword())
    		);
        userDao.saveUser(user);
    }
    
    public void updateUser(User user) {
    	userDao.updateUser(user);
    }
    
    public String hashCode(String input) {
    	
    	try {
    		MessageDigest md = MessageDigest.getInstance("MD5");
    		md.update(input.getBytes());
    		byte[] digest = md.digest();
    		String myHash = DatatypeConverter
    				.printHexBinary(digest).toUpperCase();
    		
    		return myHash;
    	} catch(Exception e) {
    		System.out.println("UserService.java: Hash encode failed.");
    	}
    	
    	return null;
    }
    
}
