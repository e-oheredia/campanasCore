package com.exact.service.campana.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="grupo_centro_costos")
public class GrupoCentroCostos extends Auspiciador {
	
	@OneToMany
	@JoinColumn(name="auspiciador_id")
	private Set<CentroCostos> centrosCostos;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
