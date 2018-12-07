package com.exact.service.campana.controller.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/provincias")
public class ProvinciaController {
	@Value("${service.lugares}")
	String serviceLugaresUrl;
	
	RestTemplate restTemplate;
	
	public ProvinciaController() {
		restTemplate = new RestTemplate();
	}
	
	@GetMapping("/{id}/distritos")
	public ResponseEntity<String> listarProvinciaByDepartamentoId(@PathVariable("id") Long id) {
		return restTemplate.getForEntity(serviceLugaresUrl + "/provincias/" + id + "/distritos", String.class);
	}
	
	@GetMapping
	public ResponseEntity<String> listarAll() {
		return restTemplate.getForEntity(serviceLugaresUrl + "/provincias", String.class);
	}
}
