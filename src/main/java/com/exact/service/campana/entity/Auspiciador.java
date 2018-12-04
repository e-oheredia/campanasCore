package com.exact.service.campana.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name="auspiciador")
@Inheritance(
	    strategy = InheritanceType.JOINED
	)
@JsonInclude(Include.NON_NULL)
public class Auspiciador implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="auspiciador_id")
	private Long id;
	
	@Transient
	private Set<CentroCostos> centrosCostos;
	
	@Transient
	private String contacto;
	@Transient
	private String direccion;
	@Transient
	private String razonSocial;
	@Transient
	private String ruc;
	
	@JsonIgnore
	public GrupoCentroCostos getGrupoCentroCostos() {
		return new GrupoCentroCostos(centrosCostos);
	}
	@JsonIgnore
	public EmpresaAuspiciadora getEmpresaAuspiciadora() {
		return new EmpresaAuspiciadora(contacto, direccion, razonSocial, ruc);
	}
	
	
	public Set<CentroCostos> getCentrosCostos() {
		return centrosCostos;
	}

	public void setCentrosCostos(Set<CentroCostos> centrosCostos) {
		this.centrosCostos = centrosCostos;
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
