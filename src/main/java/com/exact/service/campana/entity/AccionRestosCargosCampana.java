package com.exact.service.campana.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="accion_restos_cargos_campana")
public class AccionRestosCargosCampana implements Serializable {
	@Id
	private Long id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="accion_restos_campana_id", nullable=false)
	private AccionRestosCampana accionRestosCampana;
	@OneToOne
	@MapsId
	@JoinColumn(name="campana_id")
	private Campana campana;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccionRestosCampana getAccionRestosCampana() {
		return accionRestosCampana;
	}

	public void setAccionRestosCampana(AccionRestosCampana accionRestosCampana) {
		this.accionRestosCampana = accionRestosCampana;
	}

	public Campana getCampana() {
		return campana;
	}

	public void setCampana(Campana campana) {
		this.campana = campana;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
