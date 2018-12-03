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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCuentaContableCodigo() {
		return cuentaContableCodigo;
	}

	public void setCuentaContableCodigo(String cuentaContableCodigo) {
		this.cuentaContableCodigo = cuentaContableCodigo;
	}

	public String getCentroCostosCodigo() {
		return centroCostosCodigo;
	}

	public void setCentroCostosCodigo(String centroCostosCodigo) {
		this.centroCostosCodigo = centroCostosCodigo;
	}

	public String getOrdenEstadistica() {
		return ordenEstadistica;
	}

	public void setOrdenEstadistica(String ordenEstadistica) {
		this.ordenEstadistica = ordenEstadistica;
	}

	public String getGrupoArticulo() {
		return grupoArticulo;
	}

	public void setGrupoArticulo(String grupoArticulo) {
		this.grupoArticulo = grupoArticulo;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
