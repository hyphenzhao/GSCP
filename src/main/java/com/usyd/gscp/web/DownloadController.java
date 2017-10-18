package com.usyd.gscp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {
	
	@Autowired
	ServletContext context;

	@RequestMapping(value = "/downloads/{filename:.+}")
	public void download(HttpServletRequest request, 
			HttpServletResponse response,
			@PathVariable("filename") String fileName) {
		System.out.println("Downloading file :- " + fileName);
		//String downloadFolder = context.getRealPath("/WEB-INF/files/");
		String downloadFolder = "/Users/haifengzhao/Documents/workspace-sts-3.7.3.RELEASE/gscp-globalstudentcommunicationplatform/upload-dir/";
		Path file = Paths.get(downloadFolder, fileName);
		System.out.println(file);
		if (Files.exists(file)) {
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
			try {
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			} catch (IOException e) {
					System.out.println("Error :- " + e.getMessage());
			}
		} else {
			System.out.println("Sorry File not found!!!!");
		}
	}
}
