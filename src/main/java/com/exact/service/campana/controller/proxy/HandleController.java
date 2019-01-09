package com.exact.service.campana.controller.proxy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public int upload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("ruta") String ruta) throws IOException{
		
		File file = CommonUtils.multipartFileToFile(multipartFile);
				
		try {
			MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
			body.add("file", new FileSystemResource(file));
			body.add("ruta", ruta);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
			
			ResponseEntity<String> response = restTemplate.postForEntity(handleFilesPath + "/upload", new HttpEntity<>(body, headers),
				      String.class);

			return Integer.parseInt(response.getBody());
		} catch (Exception ex) {
		    return 0;
		}
		
	}
	
		
}
