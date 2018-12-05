package com.exact.service.campana.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="informacion_devolucion_restos")
public class InformacionDevolucionRestos extends AccionRestosCampana {
	
	@Column(nullable=false)
	private String contacto;
	@Column(nullable=false)
	private String direccion;
	private String observacion;
	
	public InformacionDevolucionRestos() {
		
	}
	
	public InformacionDevolucionRestos(String contacto, String direccion, String observacion) {
		this.contacto = contacto;
		this.direccion = direccion;
		this.observacion = observacion;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
