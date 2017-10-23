package com.usyd.gscp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.gscp.dao.ForumContentDao;
import com.usyd.gscp.domain.ForumContent;

@Service(value = "forumContentService")
@Transactional
public class ForumContentService {
	
	@Autowired
	ForumContentDao forumContentDao;
	
	public void createNewContent(ForumContent content) {
		forumContentDao.saveForumContent(content);
	}
	
	public void updateContent(ForumContent content) {
		forumContentDao.updateForumContent(content);
	}
	
	public ArrayList<ForumContent> getAllCotents() {
		ArrayList<ForumContent> result = (ArrayList<ForumContent>) forumContentDao.getAllContent();
		return result;
	}
	
	public ForumContent getCotentById(int id) {
		ArrayList<ForumContent> result = (ArrayList<ForumContent>) forumContentDao.getContentById("id", id);
		if(result.isEmpty()) return null;
		return result.get(0);
	}
	
	public ArrayList<ForumContent> getCotentByUserId(int id) {
		ArrayList<ForumContent> result = (ArrayList<ForumContent>) forumContentDao.getContentById("userId", id);
		return result;
	}
}
