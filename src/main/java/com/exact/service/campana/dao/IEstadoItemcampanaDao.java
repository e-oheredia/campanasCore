package com.exact.service.campana.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.campana.entity.EstadoItemCampana;

@Repository
public interface IEstadoItemcampanaDao extends CrudRepository<EstadoItemCampana, Long> {

}
