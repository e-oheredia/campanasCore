package com.exact.service.campana.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="grupo_centro_costos")
public class GrupoCentroCostos extends Auspiciador {
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="auspiciador_id")
	private Set<CentroCostos> centrosCostos;	
	
	public GrupoCentroCostos() {
		
	}

	public GrupoCentroCostos(Set<CentroCostos> centrosCostos) {
		this.centrosCostos = centrosCostos;
	}





	public Set<CentroCostos> getCentrosCostos() {
		return centrosCostos;
	}
	
	

	public void setCentrosCostos(Set<CentroCostos> centrosCostos) {
		this.centrosCostos = centrosCostos;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
