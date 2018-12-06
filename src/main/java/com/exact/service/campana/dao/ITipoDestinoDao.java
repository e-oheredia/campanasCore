package com.exact.service.campana.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.campana.entity.TipoDestino;

@Repository
public interface ITipoDestinoDao extends CrudRepository<TipoDestino, Long> {

}
