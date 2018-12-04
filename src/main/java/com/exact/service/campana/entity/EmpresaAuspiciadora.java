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
	
	public EmpresaAuspiciadora() {
		
	}

	public EmpresaAuspiciadora(String contacto, String direccion, String razonSocial, String ruc) {
		
		this.contacto = contacto;
		this.direccion = direccion;
		this.razonSocial = razonSocial;
		this.ruc = ruc;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
