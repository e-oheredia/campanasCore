package com.exact.service.campana.controller.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {
	
	@Value("${service.proveedor}")
	String serviceProveedorUrl;
	
	RestTemplate restTemplate;
	
	public ProveedorController() {
		restTemplate = new RestTemplate();
	}

	@GetMapping
	public ResponseEntity<String> listarAll(){
		return restTemplate.getForEntity(serviceProveedorUrl + "/proveedores", String.class);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> listarById(@PathVariable Long id){
		return restTemplate.getForEntity(serviceProveedorUrl + "/proveedores/" + id, String.class);
	}
}
