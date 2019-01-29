package com.exact.service.campana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.campana.entity.Region;
import com.exact.service.campana.service.interfaces.IRegionService;

@RestController
@RequestMapping("/regiones")
public class RegionController {

	@Autowired
	private IRegionService regionservice;
	
	@GetMapping
	public ResponseEntity<Iterable<Region>> listarAll(){
		return new ResponseEntity<Iterable<Region>>(regionservice.listarAll(),
				HttpStatus.OK);
	}
}
