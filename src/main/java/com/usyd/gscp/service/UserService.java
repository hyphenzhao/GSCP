package com.usyd.gscp.service;

import java.security.MessageDigest;

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
    
    public boolean authenticateUser(String account, String password) {
    	
    	
    	return false;
    }
    
    public void registerUser(User user) {
    	user.setPassword(
    			hashCode(user.getPassword())
    		);
        userDao.saveUser(user);
    }
    
    private String hashCode(String input) {
    	
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
