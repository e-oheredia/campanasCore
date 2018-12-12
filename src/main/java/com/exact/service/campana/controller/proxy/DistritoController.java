package com.exact.service.campana.controller.proxy;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/distritos")
public class DistritoController {
	
	@Value("${service.lugares}")
	String serviceLugaresUrl;
	
	RestTemplate restTemplate;
	
	public DistritoController() {
		restTemplate = new RestTemplate();
	}
	
	@GetMapping
	public ResponseEntity<String> listarAll() {
		return restTemplate.getForEntity(serviceLugaresUrl + "/distritos", String.class);
	}
	
	@GetMapping(params="ids")
	public ResponseEntity<String> listarByIds(@RequestParam List<Long> ids){
		
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromUriString(serviceLugaresUrl + "/distritos")
				.queryParam("ids", String.join(",", ids.stream().map(id -> id.toString())
						.collect(Collectors.toList())));
		
		String url = builder.toUriString();
		
		return restTemplate.getForEntity(url, String.class);
	}
}
