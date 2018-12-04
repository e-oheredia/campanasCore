package com.exact.service.campana.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="proveedor_impresion")
public class ProveedorImpresion implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="proveedor_impresion_id")
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String direccion;
	@Column(nullable=false)
	private String contacto;
	@Column(nullable=false)
	private Date fechaRecojo;
	
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public Date getFechaRecojo() {
		return fechaRecojo;
	}
	public void setFechaRecojo(Date fechaRecojo) {
		this.fechaRecojo = fechaRecojo;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
