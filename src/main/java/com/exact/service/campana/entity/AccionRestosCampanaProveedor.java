package com.exact.service.campana.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="accion_restos_campana_proveedor")
public class AccionRestosCampanaProveedor extends AccionRestosCampana {
	
	@ManyToOne
	@JoinColumn(name="accion_restos_proveedor_id")
	private AccionRestosProveedor accionRestosProveedor;
	
	public AccionRestosCampanaProveedor() {
		
	}
	
	public AccionRestosCampanaProveedor(AccionRestosProveedor accionRestosProveedor) {
		this.accionRestosProveedor = accionRestosProveedor;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AccionRestosProveedor getAccionRestosProveedor() {
		return accionRestosProveedor;
	}
	public void setAccionRestosProveedor(AccionRestosProveedor accionRestosProveedor) {
		this.accionRestosProveedor = accionRestosProveedor;
	}
}
