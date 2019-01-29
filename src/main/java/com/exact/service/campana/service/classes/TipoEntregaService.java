package com.exact.service.campana.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.campana.dao.ITipoEntregaDao;
import com.exact.service.campana.entity.TipoEntrega;
import com.exact.service.campana.service.interfaces.ITipoEntregaService;

@Service
public class TipoEntregaService implements ITipoEntregaService{

	@Autowired
	ITipoEntregaDao tipoentregadao;
	
	@Override
	public Iterable<TipoEntrega> listarAll() {
		return tipoentregadao.findAll();
	}

}
