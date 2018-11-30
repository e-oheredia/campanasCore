package com.exact.service.campana.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.campana.entity.AccionRezagoFisico;

@Repository
public interface IAccionRezagoFisicoDao extends CrudRepository<AccionRezagoFisico, Long>{

}
