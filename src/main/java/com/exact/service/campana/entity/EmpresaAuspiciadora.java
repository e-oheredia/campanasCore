package com.exact.service.campana.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="empresa_auspiciadora")
public class EmpresaAuspiciadora extends Auspiciador {
	@Column(nullable=false)
	private String contacto;
	@Column(nullable=false)
	private String direccion;
	@Column(name="razon_social",nullable=false)
	private String razonSocial;
	@Column(nullable=false)
	private String ruc;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
