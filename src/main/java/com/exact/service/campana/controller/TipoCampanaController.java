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

import com.exact.service.campana.entity.TipoCampana;
import com.exact.service.campana.service.interfaces.ITipoCampanaService;

@RestController
@RequestMapping("/tiposcampana")
public class TipoCampanaController {
	
	@Autowired
	ITipoCampanaService tipoCampanaService;
	
	@GetMapping
	public ResponseEntity<Iterable<TipoCampana>> listarTipoDestino() {
		return new ResponseEntity<Iterable<TipoCampana>>(tipoCampanaService.listarAll(), HttpStatus.OK);
	}
}
