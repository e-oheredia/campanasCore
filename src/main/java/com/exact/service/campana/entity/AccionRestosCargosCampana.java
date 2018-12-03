package com.exact.service.campana.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@ManyToOne
	@JoinColumn(name="accion_restos_campana_id", nullable=false)
	private AccionRestosCampana accionRestosCampana;
	@OneToOne
	@MapsId
	@JoinColumn(name="campana_id")
	private Campana campana;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
