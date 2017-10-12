package com.usyd.gscp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.usyd.gscp.service.ForumCommentService;
import com.usyd.gscp.service.ForumContentService;

@Controller
@SessionAttributes("current_user")
public class ForumController {
	@Autowired
	ForumContentService forumContentService;
	
	@Autowired
	ForumCommentService forumCommentService;
}
