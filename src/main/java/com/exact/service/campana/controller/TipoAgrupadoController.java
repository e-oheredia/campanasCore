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

import com.exact.service.campana.entity.TipoAgrupado;
import com.exact.service.campana.service.interfaces.ITipoAgrupadoService;

@RestController
@RequestMapping("/tipoagrupados")
public class TipoAgrupadoController {

	@Autowired
	ITipoAgrupadoService tipoAgrupadoService;
	
	@GetMapping
	public ResponseEntity<Iterable<TipoAgrupado>> listarTipoAgrupado() throws ClientProtocolException, IOException, JSONException {
		return new ResponseEntity<Iterable<TipoAgrupado>>(tipoAgrupadoService.listarTipoAgrupado(),HttpStatus.OK);
	}
	
	
}
