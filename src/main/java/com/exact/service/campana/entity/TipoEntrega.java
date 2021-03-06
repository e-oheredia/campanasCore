package com.exact.service.campana.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_entrega")
public class TipoEntrega {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tipo_entrega_id")
	private Long id;		
	
	@Column(nullable=false)
	private String nombre;
	

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
	
	

}
