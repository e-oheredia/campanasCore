package com.exact.service.campana.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.campana.entity.Campana;
import com.exact.service.campana.service.interfaces.ICampanaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
@RequestMapping("/campanas")
public class CampanaController {
	@Autowired
	ICampanaService campanaService;

	@GetMapping
	public ResponseEntity<String> listarCampanasPorEstado(@RequestParam Long estadoId) throws ClientProtocolException, IOException, JSONException{
		
		Iterable<Campana> campanas = campanaService.listarCampanasPorEstado(estadoId);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return new ResponseEntity<String>(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(campanas), HttpStatus.OK);
		
	}
	
	@GetMapping(params= {"estadoIds"})
	public ResponseEntity<String> listarCampanasPorEstados(@RequestParam List<Long> estadoIds) throws ClientProtocolException, IOException, JSONException{
		
		Iterable<Campana> campanas = campanaService.listarCampanasPorEstados(estadoIds);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return new ResponseEntity<String>(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(campanas), HttpStatus.OK);
		
	}

	@PostMapping
	public ResponseEntity<Campana> guardar(@RequestBody Campana campana, Authentication authentication) {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		return new ResponseEntity<Campana>(campanaService.guardar(campana, usuarioId, matricula), HttpStatus.OK);

	}

	@PutMapping("{id}/seleccionproveedor")
	public ResponseEntity<Campana> seleccionarProveedor(@PathVariable Long id, @RequestBody Campana campana,
			Authentication authentication) {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		return new ResponseEntity<Campana>(campanaService.seleccionarProveedor(id, campana, usuarioId, matricula), HttpStatus.OK);
	}
	
	@PutMapping("{id}/recotizacion")
	public ResponseEntity<Campana> recotizar(@PathVariable Long id, @RequestBody Campana campana,
			Authentication authentication) {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		return new ResponseEntity<Campana>(campanaService.recotizar(id, campana, usuarioId, matricula), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<String> listarById(@PathVariable Long id)
			throws ClientProtocolException, IOException, JSONException {
		Campana campana = campanaService.campanaById(id);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return new ResponseEntity<String>(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(campana), campana == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
}
