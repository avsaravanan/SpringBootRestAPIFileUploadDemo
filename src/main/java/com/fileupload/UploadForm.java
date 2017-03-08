package com.fileupload;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UploadForm {
	
	private int fileId;
	private String fileName;
	private MultipartFile file;
	
	public UploadForm(int fileId, String fileName, MultipartFile file){
		this.fileId = fileId;
		this.fileName = fileName;
		this.file = file;
	}
	
	public UploadForm(int fileId, String fileName){
		this.fileId = fileId;
		this.fileName = fileName;
		
	}
	
	public UploadForm(){};
	
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
