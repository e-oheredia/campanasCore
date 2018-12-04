package com.exact.service.campana.controller.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/paquetes")
public class PaqueteController {
	
	@Value("${service.paquetes}")
	String servicePaquetesUrl;
	
	RestTemplate restTemplate;
	
	public PaqueteController() {
		restTemplate = new RestTemplate();
	}
	
	@GetMapping
	public ResponseEntity<String> listarAll(){
		return restTemplate.getForEntity(servicePaquetesUrl + "/paquetes", String.class);
	}
	
}