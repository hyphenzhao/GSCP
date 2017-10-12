package com.usyd.gscp.service;

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
}
