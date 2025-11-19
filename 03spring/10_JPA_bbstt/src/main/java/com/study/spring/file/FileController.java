package com.study.spring.file;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
public class FileController {
	
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	//데이터를 TestDto에 담아서 던지는곳 성공시 success라고 응답
	
	@PostMapping("/api/upload")
	public ResponseEntity<String> testFileUplad(@ModelAttribute TestDto req) throws IllegalStateException, IOException{

	
		
		MultipartFile file = req.getFileUpload();
		
	}
}
