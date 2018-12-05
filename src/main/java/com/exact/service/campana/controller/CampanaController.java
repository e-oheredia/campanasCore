package com.exact.service.campana.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping
	public ResponseEntity<Campana> guardar(@RequestBody Campana campana) {
		return new ResponseEntity<Campana>(campanaService.guardar(campana), HttpStatus.OK);
	}
		
	
	@GetMapping
	public ResponseEntity<Iterable<Campana>> listarCampanasCreadas(@RequestParam Long estadoId){
		
		Iterable<Campana> campanasC = campanaService.listarCampanasPorEstado(estadoId);
		List<Campana> campanasCread = StreamSupport.stream(campanasC.spliterator(), false).collect(Collectors.toList());
					
		return new ResponseEntity<Iterable<Campana>>(campanasC, HttpStatus.OK);
		
				
		
	}
}
