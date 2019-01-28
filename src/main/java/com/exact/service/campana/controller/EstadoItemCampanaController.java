package com.exact.service.campana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exact.service.campana.entity.EstadoItemCampana;
import com.exact.service.campana.service.interfaces.IEstadoItemCampanaService;

@Controller
@RequestMapping("/estadositem")
public class EstadoItemCampanaController {
	
	@Autowired
	private IEstadoItemCampanaService estadoItemCampanaService;
	
	@GetMapping
	public ResponseEntity<Iterable<EstadoItemCampana>> listarAll(){
		return new ResponseEntity<Iterable<EstadoItemCampana>>(estadoItemCampanaService.listarAll(),
				HttpStatus.OK);
	}

}
