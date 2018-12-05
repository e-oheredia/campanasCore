package com.exact.service.campana.controller.proxy;

import java.util.List;
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
@RequestMapping("/tiposdocumento")
public class TipoDocumentoController {

	@Value("${service.tipos.documentos}")
	String serviceTipoDocumentoUrl;
	
	RestTemplate restTemplate;
	
	public TipoDocumentoController() {
		restTemplate = new RestTemplate();
	}
		
	
	@GetMapping(params = {"ids"})
	public ResponseEntity<String> listarByIds(@RequestParam List<Long> ids){
		
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromUriString(serviceTipoDocumentoUrl + "/tiposdocumento")
				.queryParam("ids", String.join(",", ids.stream().map(id -> id.toString())
						.collect(Collectors.toList())));
		
		String url = builder.toUriString();
		
		return restTemplate.getForEntity(url, String.class);
	}
}
