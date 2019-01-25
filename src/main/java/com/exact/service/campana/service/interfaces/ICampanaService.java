package com.exact.service.campana.service.interfaces;



import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import com.exact.service.campana.entity.Campana;



public interface ICampanaService {

	Campana campanaById(Long id) throws ClientProtocolException, IOException, JSONException;
	Iterable<Campana> listarCampanasPorEstado(Long estadoId, Authentication authentication) throws ClientProtocolException, IOException, JSONException;
	Iterable<Campana> listarCampanasPorEstados(List<Long> estadoIds, Authentication authentication) throws JSONException;
	Campana guardar(Campana campana, Long usuarioId, String matricula);
	Campana seleccionarProveedor(Long campanaId, Campana campana, Long usuarioId, String matricula) throws IllegalAccessException;
	Campana subirBaseProveedor(Campana campana, Long usuarioId, String matricula) throws IllegalAccessException;
	Campana confirmarBaseGeo(Long campanaId,Long usuarioId, String matricula) throws IllegalAccessException;
	Campana modificarBase(Campana campana, Long usuarioId, String matricula) throws IllegalAccessException;
	Campana recotizar(Long campanaId, Campana campana, Long usuarioId, String matricula) throws IllegalAccessException;
	Campana adjuntarConformidad(Long campanaId, Long usuarioId, String matricula, MultipartFile multipartfile) throws IOException, IllegalAccessException ;
	Campana denegarConformidad(Long campanaId, Long usuarioId, String matricula) throws IllegalAccessException;
	Campana aceptarConformidad(Long campanaId, Long usuarioId, String matricula) throws JSONException, IllegalAccessException;
	Campana solicitarMuestra(Long campanaId, Long usuarioId, String matricula) throws IllegalAccessException;
	Campana aprobarMuestra(Long campanaId, Long usuarioId, String matricula) throws IllegalAccessException;
	Campana denegarMuestra(Long campanaId, Long usuarioId, String matricula) throws IllegalAccessException;
	Campana adjuntarMuestra(Long campanaId, Long usuarioId, String matricula, MultipartFile multipartfile) throws IOException, IllegalAccessException ;
	Campana iniciarImpresion(Long campanaId, Long usuarioId, String matricula) throws IllegalAccessException;
	Campana adjuntarDatosImpresion(Campana campana, Long usuarioId, String matricula) throws IllegalAccessException;
	Campana adjuntarGuia(Long campanaId, Long usuarioId, String matricula, MultipartFile multipartfile) throws IOException, IllegalAccessException;
	Campana aprobarGuia(Long campanaId, Long usuarioId, String matricula) throws IllegalAccessException;
	Campana denegarGuia(Long campanaId, Long usuarioId, String matricula) throws IllegalAccessException;
	Campana iniciarDistribuicion(Long campanaId, Long usuarioId, String matricula);
}
