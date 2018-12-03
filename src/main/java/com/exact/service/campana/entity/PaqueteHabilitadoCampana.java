package com.exact.service.campana.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "paquete_habilitado_campana")
public class PaqueteHabilitadoCampana implements Serializable {	

	@Id
	private Long id;
	
	@OneToOne
	@JoinColumn(name="campana_id")
	@MapsId
	private Campana campana;
	
	@Column(name = "paquete_habilitado_id")
	private Long paqueteHabilitadoId;
	
	@Transient
	private Map<String, Object> paqueteHabilitado;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Campana getCampana() {
		return campana;
	}


	public void setCampana(Campana campana) {
		this.campana = campana;
	}


	public Long getPaqueteHabilitadoId() {
		return paqueteHabilitadoId;
	}


	public void setPaqueteHabilitadoId(Long paqueteHabilitadoId) {
		this.paqueteHabilitadoId = paqueteHabilitadoId;
	}


	public Map<String, Object> getPaqueteHabilitado() {
		return paqueteHabilitado;
	}


	public void setPaqueteHabilitado(Map<String, Object> paqueteHabilitado) {
		this.paqueteHabilitado = paqueteHabilitado;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
