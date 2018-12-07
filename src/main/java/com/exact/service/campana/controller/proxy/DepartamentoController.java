package com.exact.service.campana.controller.proxy;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Value("${service.lugares}")
	String serviceLugaresUrl;
	
	RestTemplate restTemplate;
	
	public DepartamentoController() {
		restTemplate = new RestTemplate();
	}
	
	@GetMapping("/{id}/provincias")
	public ResponseEntity<String> listarProvinciaByDepartamentoId(@PathVariable("id") Long id) {
		return restTemplate.getForEntity(serviceLugaresUrl + "/departamentos/" + id + "/provincias", String.class);
	}
	
	@GetMapping
	public ResponseEntity<String> listarAll() {
		return restTemplate.getForEntity(serviceLugaresUrl + "/departamentos", String.class);
	}
	
}
