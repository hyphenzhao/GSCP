package com.usyd.gscp.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service(value = "storageService")
public class FileStorageService{
	
	@Autowired
	ServletContext context;
	
	public boolean saveFile(MultipartFile file, String filename) {
		//String filePath = context.getRealPath("/WEB-INF/files/") + filename;
		String filePath = "/Users/haifengzhao/Documents/workspace-sts-3.7.3.RELEASE/gscp-globalstudentcommunicationplatform/upload-dir/"
				+ filename;
        File dest = new File(filePath);
        System.out.println(dest.getAbsolutePath());
        try {
        	file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        
		return true;
	}
}
