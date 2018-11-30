package com.exact.service.campana.service.classes;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.campana.dao.IAccionRezagoFisicoDao;
import com.exact.service.campana.entity.AccionRezagoFisico;
import com.exact.service.campana.service.interfaces.IAccionRezagoFisicoService;

@Service
public class AccionRezagoFisicoService implements IAccionRezagoFisicoService {

	@Autowired
	IAccionRezagoFisicoDao accionRezagoFisicoDao;
	
	@Override
	public Iterable<AccionRezagoFisico> listarAccionRezagoFisico()
			throws ClientProtocolException, IOException, JSONException {
		Iterable<AccionRezagoFisico> listaAccionRezagoFisico = accionRezagoFisicoDao.findAll();
		return listaAccionRezagoFisico;
	}

}
