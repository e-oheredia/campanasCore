package com.exact.service.campana.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exact.service.campana.entity.Campana;
import com.exact.service.campana.service.interfaces.ICampanaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
@RequestMapping("/campanas")
public class CampanaController {
	@Autowired
	ICampanaService campanaService;

	@GetMapping
	public ResponseEntity<String> listarCampanasPorEstado(@RequestParam Long estadoId, Authentication authentication) throws ClientProtocolException, IOException, JSONException{
		
		Iterable<Campana> campanas = campanaService.listarCampanasPorEstado(estadoId, authentication);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return new ResponseEntity<String>(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(campanas), HttpStatus.OK);		
	}
	
	@GetMapping(params= {"estadoIds"})
	public ResponseEntity<String> listarCampanasPorEstados(@RequestParam List<Long> estadoIds, Authentication authentication) throws ClientProtocolException, IOException, JSONException{
		
		Iterable<Campana> campanas = campanaService.listarCampanasPorEstados(estadoIds, authentication);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return new ResponseEntity<String>(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(campanas), HttpStatus.OK);
		
	}

	@PostMapping
	public ResponseEntity<Campana> guardar(@RequestBody Campana campana, Authentication authentication) {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		return new ResponseEntity<Campana>(campanaService.guardar(campana, usuarioId, matricula), HttpStatus.OK);

	}

	@PutMapping("{id}/seleccionproveedor")
	public ResponseEntity<Campana> seleccionarProveedor(@PathVariable Long id, @RequestBody Campana campana,
			Authentication authentication) throws IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		return new ResponseEntity<Campana>(campanaService.seleccionarProveedor(id, campana, usuarioId, matricula), HttpStatus.OK);
	}
	
	@PutMapping("{id}/recotizacion")
	public ResponseEntity<Campana> recotizar(@PathVariable Long id, @RequestBody Campana campana,
			Authentication authentication) throws IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		return new ResponseEntity<Campana>(campanaService.recotizar(id, campana, usuarioId, matricula), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<String> listarById(@PathVariable Long id)
			throws ClientProtocolException, IOException, JSONException {
		Campana campana = campanaService.campanaById(id);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return new ResponseEntity<String>(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(campana), campana == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
	
	@PutMapping("{id}/confirmarbasegeo")
	public ResponseEntity<Campana> confirmarBaseGeo(@PathVariable Long id, Authentication authentication) throws IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.confirmarBaseGeo(id, usuarioId, matricula), HttpStatus.OK);
	}
	
	@PutMapping("/subirbaseproveedor")
	public ResponseEntity<Campana> subirBaseProveedor(@RequestBody Campana campana, Authentication authentication) throws IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.subirBaseProveedor(campana, usuarioId, matricula), HttpStatus.OK);
	}
	
	@PutMapping("/modificarbasegeo")
	public ResponseEntity<Campana> modificarBaseGeo(@RequestBody Campana campana, Authentication authentication) throws IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.modificarBase(campana, usuarioId, matricula), HttpStatus.OK);
	}
	
	@PostMapping("{id}/adjuntarconformidad")
	public ResponseEntity<Campana> adjuntarConformidad(@PathVariable Long id, Authentication authentication, @RequestParam("file") MultipartFile multipartfile) throws IOException, IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.adjuntarConformidad(id, usuarioId, matricula, multipartfile), HttpStatus.OK);
	}
	
	@PutMapping("{id}/solicitarmuestra")
	public ResponseEntity<Campana> solicitarMuestra(@PathVariable Long id, Authentication authentication) throws IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.solicitarMuestra(id, usuarioId, matricula), HttpStatus.OK);
	}
	
	@PutMapping("{id}/denegarconformidad")
	public ResponseEntity<Campana> denegarConformidad(@PathVariable Long id, Authentication authentication) throws IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.denegarConformidad(id, usuarioId, matricula), HttpStatus.OK);
	}
	
	@PutMapping("{id}/aceptarconformidad")
	public ResponseEntity<Campana> aceptarConformidad(@PathVariable Long id, Authentication authentication) throws JSONException, IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.aceptarConformidad(id, usuarioId, matricula), HttpStatus.OK);
	}
	
	@PutMapping("{id}/aprobarmuestra")
	public ResponseEntity<Campana> aprobarMuestra(@PathVariable Long id, Authentication authentication) throws JSONException, IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.aprobarMuestra(id, usuarioId, matricula), HttpStatus.OK);
	}
	
	@PutMapping("{id}/denegarmuestra")
	public ResponseEntity<Campana> denegarMuestra(@PathVariable Long id, Authentication authentication) throws JSONException, IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.denegarMuestra(id, usuarioId, matricula), HttpStatus.OK);
	}
	
	@PostMapping("{id}/adjuntarmuestra")
	public ResponseEntity<Campana> adjuntarMuestra(@PathVariable Long id, Authentication authentication, @RequestParam("file") MultipartFile multipartfile) throws IOException, IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.adjuntarMuestra(id, usuarioId, matricula, multipartfile), HttpStatus.OK);
	}
	
	@PutMapping("{id}/iniciarimpresion")
	public ResponseEntity<Campana> iniciarImpresion(@PathVariable Long id, Authentication authentication) throws JSONException, IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.iniciarImpresion(id, usuarioId, matricula), HttpStatus.OK);
	}
	
	@PutMapping("/datosimpresion")
	public ResponseEntity<Campana> adjuntarDatosImpresion(@RequestBody Campana campana, Authentication authentication) throws IOException, IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.adjuntarDatosImpresion(campana, usuarioId, matricula), HttpStatus.OK);
	}
	
	@PostMapping("{id}/adjuntarguia")
	public ResponseEntity<Campana> adjuntarguia(@PathVariable Long id, Authentication authentication, @RequestParam("file") MultipartFile multipartfile) throws IOException, IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.adjuntarGuia(id, usuarioId, matricula, multipartfile), HttpStatus.OK);
	}
	

	@PutMapping("{id}/aprobarguia")
	public ResponseEntity<Campana> aprobarGuia(@PathVariable Long id, Authentication authentication) throws JSONException, IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.aprobarGuia(id, usuarioId, matricula), HttpStatus.OK);
	}
	
	@PutMapping("{id}/denegarguia")
	public ResponseEntity<Campana> denegarGuia(@PathVariable Long id, Authentication authentication) throws JSONException, IllegalAccessException {
		@SuppressWarnings("unchecked")
		Map<String, Object> datosUsuario = (Map<String, Object>) authentication.getPrincipal();
		Long usuarioId = Long.valueOf(datosUsuario.get("idUsuario").toString());
		String matricula = datosUsuario.get("matricula").toString();
		
		return new ResponseEntity<Campana>(campanaService.denegarGuia(id, usuarioId, matricula), HttpStatus.OK);
	}

	
}
