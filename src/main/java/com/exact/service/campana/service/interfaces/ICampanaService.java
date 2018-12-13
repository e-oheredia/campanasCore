package com.exact.service.campana.service.interfaces;


import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.exact.service.campana.entity.Campana;

public interface ICampanaService {

	Campana campanaById(Long id) throws ClientProtocolException, IOException, JSONException;
	Iterable<Campana> listarCampanasPorEstado(Long estadoId) throws ClientProtocolException, IOException, JSONException;
	Iterable<Campana> listarCampanasPorEstados(List<Long> estadoIds) throws JSONException;
	Campana guardar(Campana campana, Long usuarioId, String matricula);
	Campana seleccionarProveedor(Long campanaId, Campana campana, Long usuarioId, String matricula);
	Campana recotizar(Long campanaId, Campana campana, Long usuarioId, String matricula);

}
