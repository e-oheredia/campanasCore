package com.exact.service.campana.service.classes;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.campana.dao.ITipoAgrupadoDao;
import com.exact.service.campana.entity.TipoAgrupado;
import com.exact.service.campana.service.interfaces.ITipoAgrupadoService;

@Service
public class TipoAgrupadoService implements ITipoAgrupadoService {

	@Autowired
	ITipoAgrupadoDao tipoAgrupadoDao;
	
	@Override
	public Iterable<TipoAgrupado> listarTipoAgrupado() throws ClientProtocolException, IOException, JSONException {

		Iterable<TipoAgrupado> listaTipoAgrupado = tipoAgrupadoDao.findAll();
		return listaTipoAgrupado;
	}

}
