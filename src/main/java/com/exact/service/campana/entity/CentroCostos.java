package com.exact.service.campana.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="centro_costos")
public class CentroCostos implements Serializable {
	@Id
	@Column(name="centro_costos_id")
	private Long id;
	@Column(name="cuenta_contable_codigo", nullable=false)
	private String cuentaContableCodigo;
	@Column(name="centro_costos_codigo", nullable=false)
	private String centroCostosCodigo;
	@Column(name="orden_estadistica", nullable=false)
	private String ordenEstadistica;
	@Column(name="grupo_articulo")
	private String grupoArticulo;
	@Column(nullable=false)
	private double porcentaje;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
