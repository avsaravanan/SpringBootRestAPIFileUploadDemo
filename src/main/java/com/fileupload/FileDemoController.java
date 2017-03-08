package com.fileupload;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fileupload.dao.FileUploadDAO;

@Controller
public class FileDemoController {

	private static final Logger LOG = LoggerFactory
			.getLogger(FileDemoController.class);

	@Autowired
	FileUploadDAO fileUploadDAO;

	@RequestMapping("/welcome")
	public String fildDemo(ModelAndView model) {
		return "FileDemo";
	}

	@RequestMapping("/showform")
	public String showUploadFile(
			@ModelAttribute("uploadform") UploadForm uploadForm, ModelMap model) {
		model.addAttribute("uploadform", uploadForm);
		return "FileUpload";
	}

	@CrossOrigin
	@RequestMapping(value = "/saveFile", method = RequestMethod.POST)
	String saveFileHandler(@RequestParam("file") MultipartFile file,
			@ModelAttribute("uploadform") UploadForm uploadForm,
			ModelMap model, HttpServletRequest request) {

		try {

			String fileName = uploadForm.getFile().getOriginalFilename();
			model.addAttribute("filename", fileName);
			if (fileName != null && fileName.length() > 0) {

				fileUploadDAO.saveFile(file, uploadForm);
				return "FileUploadResult";
			} else {

				return "FileUploadFailure";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "FileUploadFailure";
		}

	}

	@RequestMapping(value = "/getFiles", method = RequestMethod.GET)
	public String getFiles(ModelMap model) {

		try {
			List<UploadForm> fileList = fileUploadDAO.getFiles();
			model.addAttribute("fileList", fileList);
			return "FileList";

		} catch (Exception e) {
			e.printStackTrace();
			return "FileList";
		}

	}

	@RequestMapping("/showarchive")
	public String showArchive() {

		return "FileArchive";
	}
	
	@RequestMapping("/fileuploadform")
	public String showFileUploadForm() {

		return "FileUploadForm";
	}

}
