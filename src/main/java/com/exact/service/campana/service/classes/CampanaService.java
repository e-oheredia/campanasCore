package com.exact.service.campana.service.classes;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

import com.exact.service.campana.controller.proxy.BuzonController;
import com.exact.service.campana.controller.proxy.TipoDocumentoController;
import com.exact.service.campana.controller.proxy.PlazoController;
import com.exact.service.campana.controller.proxy.ProveedorController;
import com.exact.service.campana.dao.IAccionRestosCampanaProveedorDao;
import com.exact.service.campana.dao.ICampanaDao;
import com.exact.service.campana.dao.IEmpresaAuspiciadoraDao;
import com.exact.service.campana.dao.IGrupoCentroCostosDao;
import com.exact.service.campana.dao.IInformacionDevolucionRestosDao;
import com.exact.service.campana.entity.AccionRestosCampana;
import com.exact.service.campana.entity.AccionRestosCampanaProveedor;
import com.exact.service.campana.entity.Auspiciador;
import com.exact.service.campana.entity.Campana;
import com.exact.service.campana.entity.EmpresaAuspiciadora;
import com.exact.service.campana.entity.GrupoCentroCostos;
import com.exact.service.campana.entity.InformacionDevolucionRestos;
import com.exact.service.campana.service.interfaces.ICampanaService;
import com.exact.service.campana.utils.CommonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CampanaService implements ICampanaService {

	@Autowired
	ICampanaDao campanaDao;
	
	@Autowired
	IInformacionDevolucionRestosDao informacionDevolucionRestosDao;
	
	@Autowired
	IAccionRestosCampanaProveedorDao accionRestosCampanaProveedorDao;
	
	@Autowired
	IEmpresaAuspiciadoraDao empresaAuspiciadoraDao;
	
	@Autowired
	IGrupoCentroCostosDao grupoCentroCostosDao;
	
	@Autowired
	BuzonController buzonController;
	
	@Autowired
	PlazoController plazoController;
	
	@Autowired
	ProveedorController proveedorController;
	
	@Autowired
	TipoDocumentoController tipoDocumentoController;

	@Override
	public Campana guardar(Campana campana) {
		
		AccionRestosCampana accionRestosCampanaCargos;
		AccionRestosCampana accionRestosCampanaRezagos;
		Auspiciador auspiciador;
		
		if (campana.getAccionRestosCargosCampana().getAccionRestosCampana().getAccionRestosProveedor() == null) {
			InformacionDevolucionRestos informacionDevolucionRestos = campana.getAccionRestosCargosCampana()
					.getAccionRestosCampana().getInformacionDevolucionRestos();
			accionRestosCampanaCargos = informacionDevolucionRestosDao.save(informacionDevolucionRestos);
		}else {
			AccionRestosCampanaProveedor accionRestosCampanaProveedor = campana.getAccionRestosCargosCampana()
					.getAccionRestosCampana().getAccionRestosCampanaProveedor();
			accionRestosCampanaCargos = accionRestosCampanaProveedorDao.save(accionRestosCampanaProveedor);
		}
		if (campana.getAccionRestosRezagosCampana().getAccionRestosCampana().getAccionRestosProveedor() == null) {
			InformacionDevolucionRestos informacionDevolucionRestos = campana.getAccionRestosRezagosCampana()
					.getAccionRestosCampana().getInformacionDevolucionRestos();
			accionRestosCampanaRezagos = informacionDevolucionRestosDao.save(informacionDevolucionRestos);
		}else {
			AccionRestosCampanaProveedor accionRestosCampanaProveedor = campana.getAccionRestosRezagosCampana()
					.getAccionRestosCampana().getAccionRestosCampanaProveedor();
			accionRestosCampanaRezagos = accionRestosCampanaProveedorDao.save(accionRestosCampanaProveedor);
		}
		
		if (campana.getAuspiciador().getCentrosCostos() == null) {
			EmpresaAuspiciadora empresaAuspiciadora = campana.getAuspiciador().getEmpresaAuspiciadora();
			auspiciador = empresaAuspiciadoraDao.save(empresaAuspiciadora);
		}else {
			GrupoCentroCostos grupoCentroCostos = campana.getAuspiciador().getGrupoCentroCostos();
			auspiciador = grupoCentroCostosDao.save(grupoCentroCostos);
		}
		
		campana.getAccionRestosCargosCampana().setAccionRestosCampana(accionRestosCampanaCargos);
		campana.getAccionRestosRezagosCampana().setAccionRestosCampana(accionRestosCampanaRezagos);
		campana.setAuspiciador(auspiciador);

		return campanaDao.save(campana);
	}

	@Override
	public Iterable<Campana> listarAll() {
		return campanaDao.findAll();
	}
	
	@Override
	public Campana campanaById(Long id) throws ClientProtocolException, IOException, JSONException {
		Campana campana = campanaDao.findById(id).orElse(null);
		
		if (campana !=null) {			
			
			JSONObject buzonJson = new JSONObject(buzonController.listarById(campana.getBuzonId()).getBody().toString());		
			campana.setBuzon(CommonUtils.jsonToMap(buzonJson));
			
			JSONObject plazoJson = new JSONObject(plazoController.listarById(campana.getPlazoId()).getBody().toString());		
			campana.setPlazo(CommonUtils.jsonToMap(plazoJson));
			
			JSONObject proveedorJson = new JSONObject(proveedorController.listarById(campana.getProveedorId()).getBody().toString());		
			campana.setProveedor(CommonUtils.jsonToMap(proveedorJson));
			/*
			JSONObject tipoDocumentoJson = new JSONObject(tipoDocumentoController.listarById(campana.getTipoDocumentoId()).getBody().toString());		
			campana.setTipoDocumento(CommonUtils.jsonToMap(tipoDocumentoJson));
			*/
		}
		
		return campana;
		
		//return campanaDao.findById(id).orElse(null);
	}

}
