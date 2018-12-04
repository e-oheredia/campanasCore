package com.exact.service.campana.controller.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {
	
	@Value("${service.proveedores}")
	String serviceProveedoresUrl;
	
	RestTemplate restTemplate;
	
	public ProveedorController() {
		restTemplate = new RestTemplate();
	}
	
	@GetMapping
	public ResponseEntity<String> listarAll(){
		return restTemplate.getForEntity(serviceProveedoresUrl + "/proveedores", String.class);
	}
	
}
