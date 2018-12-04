package com.exact.service.campana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.campana.entity.AccionRestosProveedor;
import com.exact.service.campana.service.interfaces.IAccionRestosProveedorService;

@RestController
@RequestMapping("/accionesrestosproveedor")
public class AccionRestosProveedorController {

	@Autowired
	IAccionRestosProveedorService accionRestosProveedorService;
	
	@GetMapping
	public ResponseEntity<Iterable<AccionRestosProveedor>> listarAll() {
		return new ResponseEntity<Iterable<AccionRestosProveedor>>(accionRestosProveedorService.listarAll(),
				HttpStatus.OK);
	}
}
