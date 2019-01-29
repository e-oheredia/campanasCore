package com.exact.service.campana.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exact.service.campana.entity.TipoEntrega;
import com.exact.service.campana.service.interfaces.ITipoEntregaService;

@Controller
@RequestMapping("/tiposentrega")
public class TipoEntregaController {

	@Autowired
	ITipoEntregaService tipoEntregaservice;
	
	@GetMapping
	public ResponseEntity<Iterable<TipoEntrega>> listarTipoDestino() throws ClientProtocolException, IOException, JSONException {
		return new ResponseEntity<Iterable<TipoEntrega>>(tipoEntregaservice.listarAll(), HttpStatus.OK);
	}
	
}
