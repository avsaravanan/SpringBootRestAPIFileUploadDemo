package com.fileupload.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.UploadForm;

@Repository
public class FileUploadImpl implements FileUploadDAO {

	private static final Logger LOG = LoggerFactory
			.getLogger(FileUploadDAO.class);

	@Override
	public void saveFile(MultipartFile file, UploadForm uploadForm) {

		try {

			String fileName = uploadForm.getFile().getOriginalFilename();

			

			LOG.info(" saving file.." + fileName);

			byte[] bytes = file.getBytes();

			File dir = new File("archive" + File.separator + "tempUploadFiles");
			if (!dir.exists()) {
				dir.mkdirs();
			}

			File serverFile = new File(dir.getAbsolutePath() + File.separator
					+ fileName);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

		} catch (Exception e) {
			
			e.printStackTrace();

		}

	}

	
	@Override
	public List<UploadForm> getFiles() {

		File dir = new File("archive" + File.separator + "tempUploadFiles");
		LOG.info("###  " + dir.getAbsolutePath());
		List<UploadForm> fileList = new ArrayList<UploadForm>();
		UploadForm upForm ;
		File folder = new File(dir.getAbsolutePath());
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				upForm = new UploadForm(i+1,listOfFiles[i].getName());
				
				fileList.add(upForm);
				LOG.info("### File " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				LOG.info("### Directory " + listOfFiles[i].getName());
			}
			
		}

		return fileList;
	}

}
