package com.exact.service.campana.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.campana.entity.Campana;
import com.exact.service.campana.service.interfaces.ICampanaService;

@RestController
@RequestMapping("campanas")
public class CampanaController {
	@Autowired
	ICampanaService campanaService;

	@PostMapping
	public ResponseEntity<Campana> guardar(@RequestBody Campana campana, Authentication authentication) {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		return new ResponseEntity<Campana>(campanaService.guardar(campana, usuarioId), HttpStatus.OK);
	}
	
	@PostMapping("{id}/seleccionproveedor")
	public ResponseEntity<Campana> seleccionarProveedor(@PathVariable Long id, @RequestBody Campana campana, Authentication authentication) {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		return new ResponseEntity<Campana>(campanaService.seleccionarProveedor(id, campana, usuarioId), HttpStatus.OK);
	}
}
