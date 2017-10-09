package com.usyd.gscp.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service(value = "storageService")
public class FileStorageService{
	private String staticPath = "/Users/haifengzhao/Documents/workspace-sts-3.7.3.RELEASE/gscp-globalstudentcommunicationplatform/upload-dir/";
	public boolean saveFile(MultipartFile file, String filename) {
        String filePath = staticPath  + filename;
        File dest = new File(filePath);
        
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
