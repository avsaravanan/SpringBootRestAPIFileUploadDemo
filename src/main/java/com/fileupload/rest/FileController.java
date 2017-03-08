package com.fileupload.rest;

import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.UploadForm;
import com.fileupload.dao.FileUploadDAO;

@Controller
@RequestMapping(value = "/rest")
public class FileController {
	private static final Logger LOG = LoggerFactory
			.getLogger(FileController.class);

	@Autowired
	FileUploadDAO fileUploadDAO;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody UploadForm showUploadForm(
			@RequestParam(value = "file", required = true) MultipartFile file) {
		

		UploadForm uploadForm = new UploadForm(1, file.getOriginalFilename(), file);
		fileUploadDAO.saveFile(file, uploadForm);
		return uploadForm;
	}
	
	@RequestMapping(value = "/getallfiles", method = RequestMethod.GET)
	 public HttpEntity<List<UploadForm>> getArchiveFiles() {
		 HttpHeaders httpHeaders = new HttpHeaders();
		 return new ResponseEntity<List<UploadForm>>(fileUploadDAO.getFiles(), httpHeaders,HttpStatus.OK);
		

	}
}
