package com.exact.service.campana.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.campana.dao.IAccionRestosProveedorDao;
import com.exact.service.campana.entity.AccionRestosProveedor;
import com.exact.service.campana.service.interfaces.IAccionRestosProveedorService;

@Service
public class AccionRestosProveedorService implements IAccionRestosProveedorService {
	
	@Autowired
	private IAccionRestosProveedorDao accionRestosProveedorDao;
	
	@Override
	public Iterable<AccionRestosProveedor> listarAll() {
		return accionRestosProveedorDao.findAll();
	}

}
