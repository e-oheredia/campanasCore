package com.exact.service.campana.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exact.service.campana.dao.IEstadoItemcampanaDao;
import com.exact.service.campana.entity.EstadoItemCampana;
import com.exact.service.campana.service.interfaces.IEstadoItemCampanaService;


@Service
public class EstadoItemCampanaService implements IEstadoItemCampanaService {
	
	@Autowired
	private IEstadoItemcampanaDao estadoItemCampanaDao;
	
	@Override
	public Iterable<EstadoItemCampana> listarAll() {
		return estadoItemCampanaDao.findAll();
	}

}
