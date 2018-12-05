package com.exact.service.campana.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.campana.entity.Campana;
@Repository
public interface ICampanaDao extends CrudRepository<Campana, Long> {


@Query("FROM Campana c WHERE c IN (SELECT sc.campana FROM SeguimientoCampana sc " 
			+ "WHERE sc.id = (SELECT MAX(sc2.id) FROM SeguimientoCampana sc2 WHERE sc2.campana.id = c.id) AND " 
			+ "sc.estadoCampana.id = ?1)")
public Iterable<Campana> listarCampanasPorEstado(Long estadoId);	


}
