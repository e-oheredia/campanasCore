package com.exact.service.campana.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="accion_restos_proveedor")
public class AccionRestosProveedor implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="accion_restos_proveedor_id")
	private Long id;
	@Column(nullable=false)
	private String nombre;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
