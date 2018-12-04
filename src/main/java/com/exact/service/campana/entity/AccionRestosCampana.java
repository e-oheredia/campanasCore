package com.exact.service.campana.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@Entity
@Table(name="accion_restos_campana")
@Inheritance(
	    strategy = InheritanceType.JOINED
	)
@JsonInclude(Include.NON_NULL)
public class AccionRestosCampana implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="accion_restos_campana_id")
	private Long id;
		
	@Transient
	private AccionRestosProveedor accionRestosProveedor;
	
	@Transient
	private String contacto;
	@Transient
	private String direccion;
	@Transient
	private String observacion;
	
	@JsonIgnore
	public InformacionDevolucionRestos getInformacionDevolucionRestos() {
		return new InformacionDevolucionRestos(this.contacto, this.direccion, this.observacion);
	}
	
	@JsonIgnore
	public AccionRestosCampanaProveedor getAccionRestosCampanaProveedor() {
		return new AccionRestosCampanaProveedor(this.accionRestosProveedor);
	}
	
	public AccionRestosProveedor getAccionRestosProveedor() {
		return accionRestosProveedor;
	}


	public void setAccionRestosProveedor(AccionRestosProveedor accionRestosProveedor) {
		this.accionRestosProveedor = accionRestosProveedor;
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

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
