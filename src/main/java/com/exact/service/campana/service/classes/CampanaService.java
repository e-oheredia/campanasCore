package com.exact.service.campana.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.campana.dao.ICampanaDao;
import com.exact.service.campana.entity.Campana;
import com.exact.service.campana.service.interfaces.ICampanaService;

@Service
public class CampanaService implements ICampanaService {
	
	@Autowired
	ICampanaDao campanaDao;
	
	@Override
	public Campana guardar(Campana campana) {
		
		
		
		return campanaDao.save(campana);
	}

}
