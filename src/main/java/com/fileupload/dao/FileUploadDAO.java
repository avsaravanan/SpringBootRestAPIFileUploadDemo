package com.fileupload.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fileupload.UploadForm;

public interface FileUploadDAO {

	void saveFile(MultipartFile file, UploadForm uploadForm);
	List<UploadForm> getFiles();
	
}
