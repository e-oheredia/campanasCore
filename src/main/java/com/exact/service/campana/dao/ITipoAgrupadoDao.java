package com.exact.service.campana.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.campana.entity.TipoAgrupado;

@Repository
public interface ITipoAgrupadoDao extends CrudRepository<TipoAgrupado, Long>{

}
