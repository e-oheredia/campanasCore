package com.exact.service.campana.controller.proxy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.exact.service.campana.utils.CommonUtils;


@RestController
@RequestMapping("permisos")
public class PermisoController {
	
	
	
	public PermisoController() {
		restTemplate = new RestTemplate();
	}

	@Value("${service.menu}")
	String serviceMenuUrl;
	
	RestTemplate restTemplate;
	
	@GetMapping
	public ResponseEntity<String> listarMenuAutenticado(Authentication authentication) throws JSONException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
			
		List<Long> permisoIds = ((List<Map<String, Object>>) CommonUtils.jsonArrayToMap(new JSONArray(datosUsuario.get("permisos").toString()))).stream()
				.map(permiso -> Long.parseLong(permiso.get("id").toString())).collect(Collectors.toList());
	    
		UriComponentsBuilder builder = UriComponentsBuilder
			    .fromUriString(serviceMenuUrl + "/menus")
			    .queryParam("permisoIds", permisoIds);
	    
	    return restTemplate.getForEntity(builder.toUriString(), String.class);
	}
	
}
