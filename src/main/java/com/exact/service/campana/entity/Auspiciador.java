package com.exact.service.campana.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="auspiciador")
@Inheritance(
	    strategy = InheritanceType.JOINED
	)
public class Auspiciador implements Serializable {
	
	@Id
	private Long id;
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
