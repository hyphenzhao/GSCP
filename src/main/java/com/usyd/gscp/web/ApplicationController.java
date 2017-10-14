package com.usyd.gscp.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.usyd.gscp.domain.Application;
import com.usyd.gscp.domain.Degree;
import com.usyd.gscp.domain.Document;
import com.usyd.gscp.domain.University;
import com.usyd.gscp.domain.User;
import com.usyd.gscp.service.ApplicationService;
import com.usyd.gscp.service.ApplicationStatusContext;
import com.usyd.gscp.service.DegreeService;
import com.usyd.gscp.service.DocumentService;
import com.usyd.gscp.service.UniversityService;
import com.usyd.gscp.service.UserRoleContext;
import com.usyd.gscp.service.UserService;

@Controller
@SessionAttributes("current_user")
public class ApplicationController {
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private UniversityService uniService;
	
	@Autowired
	private DegreeService degreeService;
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private DocumentService documentService;
	
	@RequestMapping(value = "/application/home", method = RequestMethod.GET)
	public String welcome(Locale locale, Model model,
			@ModelAttribute("current_user") User user) {
		
		if(((user.getRole() & UserRoleContext.USER_STUDENT) == 0) && ((user.getRole() & UserRoleContext.USER_AGENT) == 0)) {
			model.addAttribute("user_role", "None");
		} else if (((user.getRole() & UserRoleContext.USER_STUDENT) == 0)) {
			model.addAttribute("user_role", "Agent");
		} else if (((user.getRole() & UserRoleContext.USER_AGENT) == 0)){
			model.addAttribute("user_role", "Student");
		}
		model.addAttribute("user_first", user.getFirst());
		model.addAttribute("user_last", user.getLast());
		model.addAttribute("user_email", user.getEmail());
		model.addAttribute("user_phone", user.getPhone());
		
		return "application-home";
	}
	
	@RequestMapping(value = "/application/home", method = RequestMethod.POST)
	public String register(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@RequestParam("new_role")String newRoleString) {
		int newRoleInt = user.getRole();
		if(newRoleString.equals("student")) {
			newRoleInt |= UserRoleContext.USER_STUDENT;
			model.addAttribute("user_role", "student");
		} else {
			newRoleInt |= UserRoleContext.USER_AGENT;
			model.addAttribute("user_role", "agent");
		}
		user.setRole(newRoleInt);
		userService.updateUser(user);
		
		model.addAttribute("user_first", user.getFirst());
		model.addAttribute("user_last", user.getLast());
		model.addAttribute("user_email", user.getEmail());
		model.addAttribute("user_phone", user.getPhone());
		
		return "application-home";
	}
	
	@RequestMapping(value = "/application/student/new", method = RequestMethod.GET)
	public String newApplicaitionView(Locale locale, Model model) {
		ArrayList<University> unis = uniService.getAllUnis();
		ArrayList<Degree> degrees = degreeService.getAllDegrees();
		ArrayList<User> agents = userService.getUsersByRole(UserRoleContext.USER_AGENT);
		
		model.addAttribute("universities", unis);
		model.addAttribute("degrees", degrees);
		model.addAttribute("agents", agents);
		
		return "application-student-new";
	}
	
	@RequestMapping(value = "/application/student/new", method = RequestMethod.POST)
	public String newApplicationSubmit(Locale locale, Model model,
			@RequestParam("university") String uniId, 
			@RequestParam("degree") String degreeId,
			@RequestParam("agent") String agentId,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@ModelAttribute("current_user") User user,
			@RequestParam("file") MultipartFile file) {
		Application newApplication = new Application();
		
		newApplication.setDegreeId(Integer.parseInt(degreeId));
		newApplication.setAgentId(Integer.parseInt(agentId));
		newApplication.setStudentId(user.getId());
		newApplication.setTitle(title);
		newApplication.setContent(content);
		newApplication.setStatus(ApplicationStatusContext.STATUS_SUBMITTED);
		
		applicationService.uploadApplication(newApplication);
		
		Document newDocument = new Document();
		String orgName = file.getOriginalFilename();
		
		newDocument.setApplicationId(newApplication.getId());
		newDocument.setName(orgName);
		
		documentService.createDocument(newDocument, file);
		
		return "redirect: /gscp/application/student/history";
	}
	
	@RequestMapping(value = "/application/student/history", method = RequestMethod.GET)
	public String historyApplicationView(Locale locale, Model model,
			@ModelAttribute("current_user") User user) {
		ArrayList<Application> currentApplications = applicationService.getApplicationByStudentId(user.getId());
		ArrayList<University> unis = uniService.getAllUnis();
		ArrayList<Degree> degrees = degreeService.getAllDegrees();
		ArrayList<User> agents = userService.getUsersByRole(UserRoleContext.USER_AGENT);
		
		Collections.sort(currentApplications, new Comparator<Application>() {
	        @Override
	        public int compare(Application app1, Application app2)
	        {
	        	int result = -1;
	        	if(app1.getId() < app2.getId()){
	        		result = 1;
	        	}
	            return  result;
	        }
	    });
		
		model.addAttribute("applications", currentApplications);
		model.addAttribute("universities", unis);
		model.addAttribute("degrees", degrees);
		model.addAttribute("agents", agents);
		model.addAttribute("type", "list");
		
		return "application-student-history";
	}
	
	@RequestMapping(value = "/application/student/history/{applicationNo}", method = RequestMethod.GET)
	public String historyApplicationDetail(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@PathVariable int applicationNo) {
		ArrayList<Application> currentApplications = applicationService.getApplicationByStudentId(user.getId());
		if(currentApplications.size() == 0)
			return "redirect: /gscp/application/student/new";
		
		Collections.sort(currentApplications, new Comparator<Application>() {
	        @Override
	        public int compare(Application app1, Application app2)
	        {
	        	int result = -1;
	        	if(app1.getId() < app2.getId()){
	        		result = 1;
	        	}
	            return  result;
	        }
	    });
		Application cApplication = currentApplications.get(applicationNo - 1);
		Degree cDegree = degreeService.getDegreeById(cApplication.getDegreeId());
		University cUniversity = uniService.getUniById(cDegree.getUniId());
		ArrayList<Document> cDocuments = documentService.getDocumentsByAppId(cApplication.getId());
		
		model.addAttribute("university", cUniversity);
		model.addAttribute("degree", cDegree);
		model.addAttribute("application", cApplication);
		model.addAttribute("documents", cDocuments);
		model.addAttribute("type", "details");
		
		return "application-student-history";
	}
	
	@RequestMapping(value = "/application/student/history", method = RequestMethod.POST)
	public String studentApplicationDetailUpdate(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("application-id") int appId) {
		Application cApplication = applicationService.getApplicationById(appId).get(0);
		
		cApplication.setTitle(title);
		cApplication.setContent(content);
		
		applicationService.updateApplication(cApplication);
		
		return "redirect: /gscp/application/student/history";
	}
	
	@RequestMapping(value = "/application/agent", method = RequestMethod.GET)
	public String agentApplicationView(Locale locale, Model model,
			@ModelAttribute("current_user") User user) {
		ArrayList<Application> currentApplications = applicationService.getApplicationByAgentId(user.getId());
		ArrayList<University> unis = uniService.getAllUnis();
		ArrayList<Degree> degrees = degreeService.getAllDegrees();
		ArrayList<User> students = userService.getUsersByRole(UserRoleContext.USER_STUDENT);
		
		Collections.sort(currentApplications, new Comparator<Application>() {
	        @Override
	        public int compare(Application app1, Application app2)
	        {
	        	int result = -1;
	        	if(app1.getId() < app2.getId()){
	        		result = 1;
	        	}
	            return  result;
	        }
	    });
		
		model.addAttribute("applications", currentApplications);
		model.addAttribute("universities", unis);
		model.addAttribute("degrees", degrees);
		model.addAttribute("students", students);
		model.addAttribute("type", "list");
		
		return "application-agent";
	}
	
	@RequestMapping(value = "/application/agent/{applicationNo}", method = RequestMethod.GET)
	public String agentApplicationDetail(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@PathVariable int applicationNo) {
		ArrayList<Application> currentApplications = applicationService.getApplicationByAgentId(user.getId());
		if(currentApplications.size() == 0)
			return "redirect: /gscp/application/home";
		
		Collections.sort(currentApplications, new Comparator<Application>() {
	        @Override
	        public int compare(Application app1, Application app2)
	        {
	        	int result = -1;
	        	if(app1.getId() < app2.getId()){
	        		result = 1;
	        	}
	            return  result;
	        }
	    });
		Application cApplication = currentApplications.get(applicationNo - 1);
		Degree cDegree = degreeService.getDegreeById(cApplication.getDegreeId());
		University cUniversity = uniService.getUniById(cDegree.getUniId());
		ArrayList<Document> cDocuments = documentService.getDocumentsByAppId(cApplication.getId());
		
		model.addAttribute("university", cUniversity);
		model.addAttribute("degree", cDegree);
		model.addAttribute("application", cApplication);
		model.addAttribute("documents", cDocuments);
		model.addAttribute("type", "details");
		
		return "application-agent";
	}
	
	@RequestMapping(value = "/application/agent", method = RequestMethod.POST)
	public String agentApplicationDetailUpdate(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("status") int status,
			@RequestParam("application-id") int appId) {
		Application cApplication = applicationService.getApplicationById(appId).get(0);
		
		cApplication.setTitle(title);
		cApplication.setContent(content);
		cApplication.setStatus(status);
		
		applicationService.updateApplication(cApplication);
		
		return "redirect: /gscp/application/agent";
	}
}
