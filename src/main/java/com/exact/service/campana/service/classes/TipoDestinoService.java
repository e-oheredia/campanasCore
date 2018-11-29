package com.exact.service.campana.service.classes;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.campana.dao.ITipoDestinoDao;
import com.exact.service.campana.entity.TipoDestino;
import com.exact.service.campana.service.interfaces.ITipoDestinoService;

@Service
public class TipoDestinoService implements ITipoDestinoService {

	@Autowired
	ITipoDestinoDao tipoDestinoDao;
	
	@Override
	public Iterable<TipoDestino> listarTipoDestino() throws ClientProtocolException, IOException, JSONException {
		Iterable<TipoDestino> listaTipoDestino = tipoDestinoDao.findAll();
		return listaTipoDestino;
	}

}
