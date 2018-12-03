package com.exact.service.campana.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "item_campana")
@Inheritance(strategy = InheritanceType.JOINED)
public class ItemCampana implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_campana_id")
	private Long id;
	@Column(name = "distrito_id", nullable = false)
	private Long distritoId;
	@Transient
	private Map<String, Object> distrito;
	@Column(name = "contacto_destino")
	private String contactoDestino;
	@Column(nullable = false)
	private String direccion;
	
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
	}

	public String getContactoDestino() {
		return contactoDestino;
	}

	public void setContactoDestino(String contactoDestino) {
		this.contactoDestino = contactoDestino;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
