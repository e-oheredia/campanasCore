package com.exact.service.campana.controller;



import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.campana.entity.Campana;
import com.exact.service.campana.service.interfaces.ICampanaService;


@RestController
@RequestMapping("/campanas")
public class CampanaController {
	@Autowired	
	ICampanaService campanaService;

	
	@GetMapping
	public ResponseEntity<Iterable<Campana>> listarCampanasPorEstado(@RequestParam Long estadoId){
		
		Iterable<Campana> campanasC = campanaService.listarCampanasPorEstado(estadoId);
		List<Campana> campanasCread = StreamSupport.stream(campanasC.spliterator(), false).collect(Collectors.toList());
					
		return new ResponseEntity<Iterable<Campana>>(campanasC, HttpStatus.OK);
		
	}			
		
	@PostMapping
	public ResponseEntity<Campana> guardar(@RequestBody Campana campana, Authentication authentication) {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		return new ResponseEntity<Campana>(campanaService.guardar(campana, usuarioId), HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Campana> listarById(@PathVariable Long id) throws ClientProtocolException, IOException, JSONException{
		Campana campana = campanaService.campanaById(id);		
		return new ResponseEntity<Campana>(campana, campana == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
}
