package com.exact.service.campana.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "campana")
public class Campana {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "campana_id")
	private Long id;
	
	private String nombre;
	
	private boolean regulatorio;
	
	private boolean requiere_gps;
	
	private Long cantidad_lima;
	
	private Long cantidad_provincia;
	
	private boolean requiere_georeferencia;
	
	
	
}
