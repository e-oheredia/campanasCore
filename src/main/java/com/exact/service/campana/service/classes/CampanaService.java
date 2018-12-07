package com.exact.service.campana.service.classes;


import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import com.exact.service.campana.controller.proxy.BuzonController;
import com.exact.service.campana.controller.proxy.DistritoController;
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
import com.exact.service.campana.entity.EstadoCampana;
import com.exact.service.campana.entity.GrupoCentroCostos;
import com.exact.service.campana.entity.InformacionDevolucionRestos;
import com.exact.service.campana.entity.ItemCampana;
import com.exact.service.campana.entity.SeguimientoCampana;
import com.exact.service.campana.enumerator.EstadoCampanaEnum;
import com.exact.service.campana.service.interfaces.ICampanaService;
import com.exact.service.campana.utils.CommonUtils;

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
	
	@Autowired
	DistritoController distritoController;

	@Override
	public Campana guardar(Campana campana, Long usuarioId) {

		AccionRestosCampana accionRestosCampanaCargos;
		AccionRestosCampana accionRestosCampanaRezagos;
		Auspiciador auspiciador;

		if (campana.getAccionRestosCargosCampana().getAccionRestosCampana().getAccionRestosProveedor() == null) {
			InformacionDevolucionRestos informacionDevolucionRestos = campana.getAccionRestosCargosCampana()
					.getAccionRestosCampana().getInformacionDevolucionRestos();
			accionRestosCampanaCargos = informacionDevolucionRestosDao.save(informacionDevolucionRestos);
		} else {
			AccionRestosCampanaProveedor accionRestosCampanaProveedor = campana.getAccionRestosCargosCampana()
					.getAccionRestosCampana().getAccionRestosCampanaProveedor();
			accionRestosCampanaCargos = accionRestosCampanaProveedorDao.save(accionRestosCampanaProveedor);
		}
		if (campana.getAccionRestosRezagosCampana().getAccionRestosCampana().getAccionRestosProveedor() == null) {
			InformacionDevolucionRestos informacionDevolucionRestos = campana.getAccionRestosRezagosCampana()
					.getAccionRestosCampana().getInformacionDevolucionRestos();
			accionRestosCampanaRezagos = informacionDevolucionRestosDao.save(informacionDevolucionRestos);
		} else {
			AccionRestosCampanaProveedor accionRestosCampanaProveedor = campana.getAccionRestosRezagosCampana()
					.getAccionRestosCampana().getAccionRestosCampanaProveedor();
			accionRestosCampanaRezagos = accionRestosCampanaProveedorDao.save(accionRestosCampanaProveedor);
		}

		if (campana.getAuspiciador().getCentrosCostos() == null) {
			EmpresaAuspiciadora empresaAuspiciadora = campana.getAuspiciador().getEmpresaAuspiciadora();
			auspiciador = empresaAuspiciadoraDao.save(empresaAuspiciadora);
		} else {
			GrupoCentroCostos grupoCentroCostos = campana.getAuspiciador().getGrupoCentroCostos();
			auspiciador = grupoCentroCostosDao.save(grupoCentroCostos);
		}

		campana.getAccionRestosCargosCampana().setAccionRestosCampana(accionRestosCampanaCargos);
		campana.getAccionRestosRezagosCampana().setAccionRestosCampana(accionRestosCampanaRezagos);
		campana.setAuspiciador(auspiciador);
		campana.addSeguimientoCampana(new SeguimientoCampana("", usuarioId,
				new EstadoCampana(Long.valueOf(EstadoCampanaEnum.CREADO.getValue()))));

		return campanaDao.save(campana);
	}

	@Override
	public Campana seleccionarProveedor(Long campanaId, Campana campana, Long usuarioId) {
		Campana campanaBD = campanaDao.findById(campanaId).orElse(null);
		campanaBD.setProveedor(campana.getProveedor());
		campanaBD.setCostoCampana(campana.getCostoCampana());
		campanaBD.setTipoCampana(campana.getTipoCampana());
		campanaBD.addSeguimientoCampana(
				new SeguimientoCampana("Proveedor: ".concat(campana.getProveedor().get("nombre").toString())
						.concat(". Costo: ").concat(String.valueOf(campana.getCostoCampana())), usuarioId, 
						new EstadoCampana(Long.valueOf(EstadoCampanaEnum.ASIGNADO.getValue()))));
		
		return campanaDao.save(campanaBD);

	}



	@Override
	public Iterable<Campana> listarCampanasPorEstado(Long estadoId) throws ClientProtocolException, IOException, JSONException {
		
		Iterable<Campana> campanas = campanaDao.listarCampanasPorEstado(estadoId);
		List<Campana> campanasList = StreamSupport.stream(campanas.spliterator(), false).collect(Collectors.toList());
		
		if(campanasList == null) {
			return null;
		}		
		
		List<ItemCampana> itemsCampana = new ArrayList<ItemCampana>();
		campanasList.forEach(campana -> campana.getItemsCampana().forEach(itemCampana -> itemsCampana.add(itemCampana)));
		
		//Distritos
		List<Long> distritoIds = itemsCampana.stream().map(ItemCampana::getDistritoId).collect(Collectors.toList());
		JSONArray distritoJson = new JSONArray(distritoController.listarByIds(distritoIds).getBody().toString());		
		List<Map<String, Object>> distritos = StreamSupport.stream(CommonUtils.jsonArrayToMap(distritoJson).spliterator(),false).collect(Collectors.toList());;
		
		for (ItemCampana itemCampana: itemsCampana) {
			int i = 0;
			while (i < distritos.size()) {
				if (itemCampana.getDistritoId().longValue() == Long.valueOf(distritos.get(i).get("id").toString())) {
					itemCampana.setDistrito(distritos.get(i));
					break;
				}
				i++;
			}
		}
		
		//Buzones
		List<Long> buzonIds = campanasList.stream().map(Campana::getBuzonId).collect(Collectors.toList());		
		JSONArray buzonJson = new JSONArray(buzonController.listarByIds(buzonIds).getBody().toString());		
		List<Map<String, Object>> buzones = StreamSupport.stream(CommonUtils.jsonArrayToMap(buzonJson).spliterator(),false).collect(Collectors.toList());;
		
		//Plazos		
		JSONArray plazoJson = new JSONArray(plazoController.listarAll().getBody().toString());		
		List<Map<String, Object>> plazos = StreamSupport.stream(CommonUtils.jsonArrayToMap(plazoJson).spliterator(),false).collect(Collectors.toList());;
		
		//Proveedores	
		JSONArray proveedorJson = new JSONArray(proveedorController.listarAll().getBody().toString());		
		List<Map<String, Object>> proveedores = StreamSupport.stream(CommonUtils.jsonArrayToMap(proveedorJson).spliterator(),false).collect(Collectors.toList());;
			
		//TiposDocumento
		List<Long> tiposDocumentoIds = campanasList.stream().map(Campana::getTipoDocumentoId).collect(Collectors.toList());		
		JSONArray tiposDocumentoJson = new JSONArray(tipoDocumentoController.listarByIds(tiposDocumentoIds).getBody().toString());		
		List<Map<String, Object>> tiposDocumento = StreamSupport.stream(CommonUtils.jsonArrayToMap(tiposDocumentoJson).spliterator(),false).collect(Collectors.toList());;
					
		
		for(Campana c : campanasList) {
			
			int i = 0;
			while (i < buzones.size()) {
				if (c.getBuzonId().longValue() == Long.valueOf(buzones.get(i).get("id").toString())) {
					c.setBuzon(buzones.get(i));
					break;
				}
				i++;
			}
			
			
			int j = 0;
			while (j < plazos.size()) {
				if (c.getPlazoId().longValue() == Long.valueOf(plazos.get(j).get("id").toString())) {
					c.setPlazo(plazos.get(j));
					break;
				}
				j++;
			}
			
			
			int k = 0;
			while (k < proveedores.size()) {
				if (c.getProveedorId() == null) {
					break;
				}
				if (c.getProveedorId().longValue() == Long.valueOf(proveedores.get(k).get("id").toString())) {
					c.setProveedor(proveedores.get(k));
					break;
				}
				k++;
			}
			
			
			int l = 0;
			while (l < tiposDocumento.size()) {
				if (c.getTipoDocumentoId().longValue() == Long.valueOf(tiposDocumento.get(l).get("id").toString())) {
					c.setTipoDocumento(tiposDocumento.get(l));
					break;
				}
				l++;
			}
		}
				
		return campanasList;
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
		}
		
		return campana;
	}

}
