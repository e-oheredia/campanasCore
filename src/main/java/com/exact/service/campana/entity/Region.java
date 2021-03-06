package com.exact.service.campana.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="region")
public class Region {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="region_id")
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private byte plazo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte getPlazo() {
		return plazo;
	}
	public void setPlazo(byte plazo) {
		this.plazo = plazo;
	}
	
	

}
