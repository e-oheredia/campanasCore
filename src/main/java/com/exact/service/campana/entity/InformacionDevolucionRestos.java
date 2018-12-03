package com.exact.service.campana.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="informacion_devolucion_restos")
public class InformacionDevolucionRestos extends AccionRestosCampana {
	
	@Column(nullable=false)
	private String contacto;
	@Column(nullable=false)
	private String direccion;
	@Column(nullable=false)
	private String observacion;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
