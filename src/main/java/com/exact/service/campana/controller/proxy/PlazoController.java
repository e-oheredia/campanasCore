package com.exact.service.campana.controller.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/plazos")
public class PlazoController {
	
	@Value("${service.plazos}")
	String servicePlazosUrl;
	
	RestTemplate restTemplate;
	
	public PlazoController() {
		restTemplate = new RestTemplate();
	}
	
	@GetMapping
	public ResponseEntity<String> listarAll(){
		return restTemplate.getForEntity(servicePlazosUrl + "/plazos", String.class);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> listarById(@PathVariable Long id){
		return restTemplate.getForEntity(servicePlazosUrl + "/plazos/" + id, String.class);
	}
	
}
