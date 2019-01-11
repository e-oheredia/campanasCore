package com.exact.service.campana.entity;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_campana")
@Inheritance(strategy = InheritanceType.JOINED)
public class ItemCampana implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_campana_id")
	private Long id;
	@Column(name = "distrito_id", nullable = false)
	@JsonIgnore
	private Long distritoId;
	@Transient
	private Map<String, Object> distrito;
	@Column(name = "nombres", nullable = false)
	private String nombres;
	@Column(name = "apellido_paterno", nullable = false)
	private String apellidoPaterno;
	@Column(name = "apellido_materno", nullable = false)
	private String apellidoMaterno;
	@Column(nullable = false)
	private String direccion;
	@Column(name="razon_social", nullable=true)
	private String razonSocial;
	@Column(name="enviable", nullable=false)
	private boolean enviable;
	@Column(name="correlativo", nullable=true)
	private int correlativo;
	
	@Column(name="correlativo_base", nullable=false)
	private int correlativoBase;
	
	public boolean isEnviable() {
		return enviable;
	}

	
	public int getCorrelativo() {
		return correlativo;
	}


	public void setCorrelativo(int correlativo) {
		this.correlativo = correlativo;
	}


	public void setEnviable(boolean enviable) {
		this.enviable = enviable;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDistritoId() {
		return distritoId;
	}

	public void setDistritoId(Long distritoId) {
		this.distritoId = distritoId;
	}

	public Map<String, Object> getDistrito() {
		return distrito;
	}

	public void setDistrito(Map<String, Object> distrito) {
		this.distrito = distrito;
		this.distritoId = Long.valueOf(distrito.get("id").toString());
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@JsonIgnore
	@SuppressWarnings("unchecked")
	public String getClasificacion() {
		String valor="";
		
		Map<String, Object> MapProvincia = (Map<String, Object>) this.getDistrito().get("provincia");
		
		if(MapProvincia.get("nombre").toString().trim().equals("Lima") || MapProvincia.get("nombre").toString().trim().equals("Callao")) {
			valor = "Lima Metropolitana y Callao";
		}else {
			valor = "Provincia";
		}
		return valor;
	}
		
	private static final long serialVersionUID = 1L;
}

