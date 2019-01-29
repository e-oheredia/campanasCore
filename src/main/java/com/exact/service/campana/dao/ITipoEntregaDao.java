package com.exact.service.campana.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.campana.entity.TipoEntrega;

@Repository
public interface ITipoEntregaDao extends CrudRepository<TipoEntrega, Long>{

	
	
}
