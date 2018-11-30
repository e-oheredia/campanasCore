package com.exact.service.campana.service.interfaces;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.exact.service.campana.entity.AccionCargoFisico;

public interface IAccionCargoFisicoService {

	Iterable<AccionCargoFisico> listarAccionCargoFisico() throws ClientProtocolException, IOException, JSONException;
}
