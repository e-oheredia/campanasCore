package com.exact.service.campana.service.interfaces;


import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.exact.service.campana.entity.Campana;

public interface ICampanaService {

	Campana campanaById(Long id) throws ClientProtocolException, IOException, JSONException;
	
	Iterable<Campana> listarCampanasPorEstado(Long estadoId) throws ClientProtocolException, IOException, JSONException;

	Campana guardar(Campana campana, Long usuarioId);

}
