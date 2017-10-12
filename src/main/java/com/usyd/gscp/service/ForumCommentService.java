package com.usyd.gscp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.gscp.dao.ForumCommentDao;
import com.usyd.gscp.domain.ForumComment;

@Service(value = "forumCommentService")
@Transactional
public class ForumCommentService {
	
	@Autowired
	ForumCommentDao forumCommentDao;
	
	public void createNewComment(ForumComment comment) {
		forumCommentDao.saveForumComment(comment);
	}
	
	public void updateComment(ForumComment comment) {
		forumCommentDao.updateForumComment(comment);
	}
	
	public ArrayList<ForumComment> getAllComments() {
		ArrayList<ForumComment> result = (ArrayList<ForumComment>) forumCommentDao.getAllComments();
		return result;
	}
	
	public ForumComment getCommentById(int id) {
		ArrayList<ForumComment> result = (ArrayList<ForumComment>) forumCommentDao.getCommentById("id", id);
		return result.get(0);
	}
	
	public ArrayList<ForumComment> getCommentsByUserId(int id) {
		ArrayList<ForumComment> result = (ArrayList<ForumComment>) forumCommentDao.getCommentById("userId", id);
		return result;
	}
	
	public ArrayList<ForumComment> getCommentsByContentId(int id) {
		ArrayList<ForumComment> result = (ArrayList<ForumComment>) forumCommentDao.getCommentById("contentId", id);
		return result;
	}
}
