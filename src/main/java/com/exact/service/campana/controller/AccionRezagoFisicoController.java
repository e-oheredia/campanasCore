package com.exact.service.campana.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.campana.entity.AccionRezagoFisico;
import com.exact.service.campana.service.interfaces.IAccionRezagoFisicoService;

@RestController
@RequestMapping("/accionrezagofisicos")
public class AccionRezagoFisicoController {

	@Autowired
	IAccionRezagoFisicoService accionRezagoFisicoService;
	
	@GetMapping
	public ResponseEntity<Iterable<AccionRezagoFisico>> listarAccionRezagoFisico() throws ClientProtocolException, IOException, JSONException {
		return new ResponseEntity<Iterable<AccionRezagoFisico>>(accionRezagoFisicoService.listarAccionRezagoFisico(), HttpStatus.OK);
	}
}
