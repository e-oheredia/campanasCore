package com.exact.service.campana.controller.proxy;

import java.io.File;
import java.io.IOException;


import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.springframework.beans.factory.annotation.Value;
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
	public int upload(MultipartFile multipartFile) throws IOException{
		
		try {
			MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
			body.add("file", multipartFile);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
			
			ResponseEntity<byte[]> response = restTemplate.postForEntity(handleFilesPath + "/upload", new HttpEntity<>(body, headers),
				      byte[].class);

			return Integer.parseInt(response.toString());
		} catch (Exception ex) {
		    return 0;
		}
		
	}
	
}
