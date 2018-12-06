package com.exact.service.campana.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="accion_restos_cargos_campana")
public class AccionRestosCargosCampana implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="accion_restos_cargos_campana_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="accion_restos_campana_id")
	private AccionRestosCampana accionRestosCampana;	

	public AccionRestosCampana getAccionRestosCampana() {
		return accionRestosCampana;
	}

	public void setAccionRestosCampana(AccionRestosCampana accionRestosCampana) {
		this.accionRestosCampana = accionRestosCampana;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
