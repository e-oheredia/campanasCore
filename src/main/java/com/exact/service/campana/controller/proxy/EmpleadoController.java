package com.exact.service.campana.controller.proxy;

import java.util.Map;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("empleados")
public class EmpleadoController {

	RestTemplate restTemplate;
	
	public EmpleadoController() {
		restTemplate = new RestTemplate();
	}
	
	@Value("${service.empleados}")
	String serviceEmpleadosUrl;
	
	@GetMapping("/autenticado")
	public ResponseEntity<String> listarEmpleadoAuthenticado(Authentication authentication) throws JSONException  {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		
		String matricula = (String) datosUsuario.get("matricula");
		
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromUriString(serviceEmpleadosUrl + "/empleados")
			    .queryParam("matricula", matricula);
		
		
		String url = builder.toUriString();
	    
	    return restTemplate.getForEntity(url, String.class);
	}
	
}
