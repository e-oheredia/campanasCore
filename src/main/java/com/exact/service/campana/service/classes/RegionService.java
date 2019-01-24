package com.exact.service.campana.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.campana.dao.IRegionDao;
import com.exact.service.campana.entity.Region;
import com.exact.service.campana.service.interfaces.IRegionService;

@Service
public class RegionService implements IRegionService{

	@Autowired
	private IRegionDao regiondao;
	
	@Override
	public Iterable<Region> listarAll() {
		return regiondao.findAll();
	}

}
