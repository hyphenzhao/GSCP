package com.usyd.gscp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.gscp.dao.ForumCommentDao;
import com.usyd.gscp.domain.ForumComment;

@Service(value = "forumCommentService")
@Transactional
public class ForumCommentService {
	
	@Autowired
	ForumCommentDao forumContentDao;
	
	public void createNewContent(ForumComment comment) {
		forumContentDao.saveForumContent(comment);
	}
}
