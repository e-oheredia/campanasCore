package com.exact.service.campana.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.campana.dao.ITipoCampanaDao;
import com.exact.service.campana.entity.TipoCampana;
import com.exact.service.campana.service.interfaces.ITipoCampanaService;

@Service
public class TipoCampanaService implements ITipoCampanaService {
	
	@Autowired
	ITipoCampanaDao tipoCampanaDao;
	
	@Override
	public Iterable<TipoCampana> listarAll() {
		return tipoCampanaDao.findAll();
	}

}
