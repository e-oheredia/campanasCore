package com.exact.service.campana.service.interfaces;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.exact.service.campana.entity.AccionRezagoFisico;

public interface IAccionRezagoFisicoService {

	Iterable<AccionRezagoFisico> listarAccionRezagoFisico()throws ClientProtocolException, IOException, JSONException;
}
