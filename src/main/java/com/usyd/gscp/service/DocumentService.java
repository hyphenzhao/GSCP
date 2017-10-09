package com.usyd.gscp.service;

import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.usyd.gscp.dao.DocumentDao;
import com.usyd.gscp.domain.Document;

@Service(value = "documentService")
@Transactional
public class DocumentService {
	
	@Autowired
	private DocumentDao documentDao;
	
	@Autowired
	private FileStorageService storageService;
	
	public void createDocument(Document document, MultipartFile file) {
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		String newFileName = getSaltString() + "." + extension;
		document.setPath(newFileName);
		documentDao.saveDocument(document);
		
		boolean result = storageService.saveFile(file, newFileName);
		if(result){
			System.out.println("Save file successfully.");
		} else {
			System.out.println("Save file failed.");
		}
	}
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }


}
