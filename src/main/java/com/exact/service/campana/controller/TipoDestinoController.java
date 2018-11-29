package com.exact.service.campana.controller;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.exact.service.campana.entity.TipoDestino;
import com.exact.service.campana.service.interfaces.ITipoDestinoService;

@RestController
@RequestMapping("/tipodestinos")
public class TipoDestinoController {
	
	@Autowired
	ITipoDestinoService tipoDestinoService;
	
	@GetMapping
	public ResponseEntity<Iterable<TipoDestino>> listarTipoDestino() throws ClientProtocolException, IOException, JSONException {
		return new ResponseEntity<Iterable<TipoDestino>>(tipoDestinoService.listarTipoDestino(), HttpStatus.OK);
	}

}
