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

import com.exact.service.campana.entity.AccionCargoFisico;
import com.exact.service.campana.service.interfaces.IAccionCargoFisicoService;

@RestController
@RequestMapping("/accioncargofisicos")
public class AccionCargoFisicoController {

	@Autowired
	IAccionCargoFisicoService accionCargoFisicoService;
	
	@GetMapping
	public ResponseEntity<Iterable<AccionCargoFisico>> listarAccionCargoFisico() throws ClientProtocolException, IOException, JSONException {
		return new ResponseEntity<Iterable<AccionCargoFisico>>(accionCargoFisicoService.listarAccionCargoFisico(), HttpStatus.OK);
	}
}
