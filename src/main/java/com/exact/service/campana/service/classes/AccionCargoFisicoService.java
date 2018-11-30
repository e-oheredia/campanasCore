package com.exact.service.campana.service.classes;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.campana.dao.IAccionCargoFisicoDao;
import com.exact.service.campana.entity.AccionCargoFisico;
import com.exact.service.campana.service.interfaces.IAccionCargoFisicoService;

@Service
public class AccionCargoFisicoService implements IAccionCargoFisicoService {

	@Autowired
	IAccionCargoFisicoDao accionCargoFisicoDao;
	
	@Override
	public Iterable<AccionCargoFisico> listarAccionCargoFisico()
			throws ClientProtocolException, IOException, JSONException {
		Iterable<AccionCargoFisico> listaAccionCargoFisico = accionCargoFisicoDao.findAll();
		return listaAccionCargoFisico;
	}

}
