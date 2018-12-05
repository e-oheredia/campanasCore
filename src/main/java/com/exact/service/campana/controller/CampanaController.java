package com.exact.service.campana.controller;


import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<Iterable<Campana>> listarAll(){
		return new ResponseEntity<Iterable<Campana>>(campanaService.listarAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Campana> listarById(@PathVariable Long id) throws ClientProtocolException, IOException, JSONException{
		Campana campana = campanaService.campanaById(id);		
		return new ResponseEntity<Campana>(campana, campana == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
}
