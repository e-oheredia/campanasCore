package com.exact.service.campana.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "seguimiento_campana")
public class SeguimientoCampana implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seguimiento_campana_id")
	private Long id;
	private String observacion;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone="America/Lima")
	private Date fecha;
	@Column(nullable = false, name = "usuario_id")
	private Long usuarioId;
	@Transient
	private Map<String, Object> usuario;	
	@ManyToOne(optional=false, targetEntity= EstadoCampana.class)
	@JoinColumn(name="estado_campana_id")
	private EstadoCampana estadoCampana;
}
