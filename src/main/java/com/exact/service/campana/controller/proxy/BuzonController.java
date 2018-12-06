package com.exact.service.campana.controller.proxy;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/buzones")
public class BuzonController {

	@Value("${service.empleados}")
	String serviceEmpleadosUrl;
	
	RestTemplate restTemplate;
	
	public BuzonController() {
		restTemplate = new RestTemplate();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> listarById(@PathVariable Long id){
		return restTemplate.getForEntity(serviceEmpleadosUrl + "/buzones/" + id, String.class);	
	}
	
	@GetMapping(params="ids")
	public ResponseEntity<String> listarByIds(@RequestParam List<Long> ids){
		
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromUriString(serviceEmpleadosUrl + "/buzones")
				.queryParam("ids", String.join(",", ids.stream().map(id -> id.toString())
						.collect(Collectors.toList())));
		
		String url = builder.toUriString();
		
		return restTemplate.getForEntity(url, String.class);
	}
	
	@GetMapping()
	public ResponseEntity<String> listarAll(){
		return restTemplate.getForEntity(serviceEmpleadosUrl + "/buzones", String.class);
	}
}
