package com.exact.service.campana.service.classes;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

import com.exact.service.campana.controller.proxy.BuzonController;
import com.exact.service.campana.controller.proxy.DistritoController;
import com.exact.service.campana.controller.proxy.PaqueteController;
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
	
	@Autowired
	PaqueteController paqueteController;

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
		campanaBD.addSeguimientoCampana(new SeguimientoCampana(
				"Proveedor: ".concat(campana.getProveedor().get("nombre").toString()).concat(". Costo: ")
						.concat(String.valueOf(campana.getCostoCampana())),
				usuarioId, new EstadoCampana(Long.valueOf(EstadoCampanaEnum.ASIGNADO.getValue()))));

		return campanaDao.save(campanaBD);

	}

	@Override
	public Iterable<Campana> listarCampanasPorEstado(Long estadoId)
			throws ClientProtocolException, IOException, JSONException {

		Iterable<Campana> campanas = campanaDao.listarCampanasPorEstado(estadoId);
		List<Campana> campanasList = StreamSupport.stream(campanas.spliterator(), false).collect(Collectors.toList());

		if (campanasList == null) {
			return null;
		}

		List<ItemCampana> itemsCampana = getItemsCampanasFromCampanas(campanasList);

		// Distritos
		List<Map<String, Object>> distritos = getAtributosFromItemsCampana(itemsCampana,
				distritoController::listarByIds, ItemCampana::getDistritoId);

		setDistritosToItemsCampana(itemsCampana, distritos);

		// Buzones
		List<Map<String, Object>> buzones = getAtributosFromCampanas(campanasList, buzonController::listarByIds,
				Campana::getBuzonId);

		// Plazos
		List<Map<String, Object>> plazos = getAtributosFromCampanas(campanasList, plazoController::listarAll);

		// Proveedores
		List<Map<String, Object>> proveedores = getAtributosFromCampanas(campanasList, proveedorController::listarAll);
		
		List<Map<String, Object>> paquetesHabilitado = getAtributosFromCampanas(campanasList, paqueteController::listarAll);

		// TiposDocumento
		List<Map<String, Object>> tiposDocumento = getAtributosFromCampanas(campanasList,
				tipoDocumentoController::listarByIds, Campana::getTipoDocumentoId);

		setAtributosToCampanas(campanasList,  buzones, plazos, proveedores, tiposDocumento, paquetesHabilitado);

		return campanasList;
	}

	@Override
	public Campana campanaById(Long id) throws ClientProtocolException, IOException, JSONException {
		Campana campana = campanaDao.findById(id).orElse(null);

		if (campana != null) {

			JSONObject buzonJson = new JSONObject(
					buzonController.listarById(campana.getBuzonId()).getBody().toString());
			campana.setBuzon(CommonUtils.jsonToMap(buzonJson));

			JSONObject plazoJson = new JSONObject(
					plazoController.listarById(campana.getPlazoId()).getBody().toString());
			campana.setPlazo(CommonUtils.jsonToMap(plazoJson));

			JSONObject proveedorJson = new JSONObject(
					proveedorController.listarById(campana.getProveedorId()).getBody().toString());
			campana.setProveedor(CommonUtils.jsonToMap(proveedorJson));
		}

		return campana;
	}
	
	@Override
	public Iterable<Campana> listarCampanasPorEstados(List<Long> estadoIds) throws JSONException {
		Iterable<Campana> campanas = campanaDao.listarCampanasPorEstados(estadoIds);
		List<Campana> campanasList = StreamSupport.stream(campanas.spliterator(), false).collect(Collectors.toList());

		if (campanasList == null) {
			return null;
		}

		List<ItemCampana> itemsCampana = getItemsCampanasFromCampanas(campanasList);

		// Distritos
		List<Map<String, Object>> distritos = getAtributosFromItemsCampana(itemsCampana,
				distritoController::listarByIds, ItemCampana::getDistritoId);

		setDistritosToItemsCampana(itemsCampana, distritos);

		// Buzones
		List<Map<String, Object>> buzones = getAtributosFromCampanas(campanasList, buzonController::listarByIds,
				Campana::getBuzonId);

		// Plazos
		List<Map<String, Object>> plazos = getAtributosFromCampanas(campanasList, plazoController::listarAll);

		// Proveedores
		List<Map<String, Object>> proveedores = getAtributosFromCampanas(campanasList, proveedorController::listarAll);
		
		List<Map<String, Object>> paquetesHabilitado = getAtributosFromCampanas(campanasList, paqueteController::listarAll);

		// TiposDocumento
		List<Map<String, Object>> tiposDocumento = getAtributosFromCampanas(campanasList,
				tipoDocumentoController::listarByIds, Campana::getTipoDocumentoId);

		setAtributosToCampanas(campanasList,  buzones, plazos, proveedores, tiposDocumento, paquetesHabilitado);

		return campanasList;
	}


	/*****************************************************************************************************/

	private List<Map<String, Object>> getAtributosFromItemsCampana(List<ItemCampana> itemsCampana,
			Function<List<Long>, ResponseEntity<String>> funcion, Function<? super ItemCampana, ? extends Long> mapper)
			throws JSONException {
		List<Long> registroIds = itemsCampana.stream().map(mapper).collect(Collectors.toList());
		JSONArray registrosJson = new JSONArray(funcion.apply(registroIds).getBody().toString());
		List<Map<String, Object>> registros = StreamSupport
				.stream(CommonUtils.jsonArrayToMap(registrosJson).spliterator(), false).collect(Collectors.toList());
		return registros;
	}

	private List<Map<String, Object>> getAtributosFromCampanas(List<Campana> campanas,
			Function<List<Long>, ResponseEntity<String>> funcion, Function<? super Campana, ? extends Long> mapper)
			throws JSONException {
		List<Long> registroIds = campanas.stream().map(mapper).collect(Collectors.toList());
		JSONArray registrosJson = new JSONArray(funcion.apply(registroIds).getBody().toString());
		List<Map<String, Object>> registros = StreamSupport
				.stream(CommonUtils.jsonArrayToMap(registrosJson).spliterator(), false).collect(Collectors.toList());
		return registros;
	}

	private List<Map<String, Object>> getAtributosFromCampanas(List<Campana> campanas,
			Supplier<ResponseEntity<String>> funcion) throws JSONException {
		JSONArray registrosJson = new JSONArray(funcion.get().getBody().toString());
		List<Map<String, Object>> registros = StreamSupport
				.stream(CommonUtils.jsonArrayToMap(registrosJson).spliterator(), false).collect(Collectors.toList());
		return registros;
	}

	private void setDistritosToItemsCampana(List<ItemCampana> itemsCampana, List<Map<String, Object>> distritos) {
		for (ItemCampana itemCampana : itemsCampana) {
			int i = 0;
			while (i < distritos.size()) {
				if (itemCampana.getDistritoId().longValue() == Long.valueOf(distritos.get(i).get("id").toString())) {
					itemCampana.setDistrito(distritos.get(i));
					break;
				}
				i++;
			}
		}
	}

	private void setAtributosToCampanas(List<Campana> campanasList, List<Map<String, Object>> buzones,
			List<Map<String, Object>> plazos, List<Map<String, Object>> proveedores, List<Map<String, Object>> tiposDocumento, List<Map<String, Object>> paquetes) {
		for (Campana c : campanasList) {

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
			
			
			if (c.getPaqueteHabilitadoId() != null) {
				int m = 0;
				while (m < paquetes.size()) {
					if (c.getPaqueteHabilitadoId().longValue() == Long.valueOf(paquetes.get(m).get("id").toString())) {
						c.setPaqueteHabilitado(paquetes.get(m));
						break;
					}
					m++;
				}
			}
			
		}
	}

	private List<ItemCampana> getItemsCampanasFromCampanas(List<Campana> campanas) {
		List<ItemCampana> itemsCampana = new ArrayList<ItemCampana>();
		campanas.forEach(campana -> campana.getItemsCampana().forEach(itemCampana -> itemsCampana.add(itemCampana)));
		return itemsCampana;
	}

	
}
