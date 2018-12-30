package com.exact.service.campana.controller.proxy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.exact.service.campana.utils.CommonUtils;

@RestController
@RequestMapping("/adjuntar")
public class HandleController {

	@Value("${service.handle.files}")
	private String handleFilesPath;
	
	RestTemplate restTemplate;

	public HandleController() {
		restTemplate = new RestTemplate();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public int upload(@RequestParam("file") MultipartFile multipartFile) throws IOException{
		
		try {
			MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
			body.add("file", new FileSystemResource	(convert(multipartFile)));
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
			
			ResponseEntity<String> response = restTemplate.postForEntity(handleFilesPath + "/upload", new HttpEntity<>(body, headers),
				      String.class);

			return Integer.parseInt(response.getBody().toString());
		} catch (Exception ex) {
		    return 0;
		}
		
	}
	
	public static File convert(MultipartFile file)
	  {    
	    File convFile = new File(file.getOriginalFilename());
	    try {
	        convFile.createNewFile();
	          FileOutputStream fos = new FileOutputStream(convFile); 
	            fos.write(file.getBytes());
	            fos.close(); 
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } 

	    return convFile;
	 }
	
}
