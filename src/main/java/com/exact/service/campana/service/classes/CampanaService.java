package com.exact.service.campana.service.classes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.exact.service.campana.entity.SeguimientoCampana;
import com.exact.service.campana.enumerator.EstadoCampanaEnum;
import com.exact.service.campana.service.interfaces.ICampanaService;

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
		
		return campanaDao.save(campana);

	}



	@Override
	public Iterable<Campana> listarCampanasPorEstado(Long estadoId) {
		
		Iterable<Campana> campanasCreadas = campanaDao.listarCampanasPorEstado(estadoId);
		List<Campana> campanasCread = StreamSupport.stream(campanasCreadas.spliterator(), false).collect(Collectors.toList());
		
		if(campanasCread==null) {
			return null;
		}
				
		return campanasCread;
	}

}
