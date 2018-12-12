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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private Long usuarioId;
	@Transient
	private Map<String, Object> usuario;	
	
	@Column(name = "matricula", nullable = false)
	@JsonIgnore
	private String matricula;
	
	@Transient
	private Map<String, Object> empleado;	
	
	@ManyToOne(optional=false, targetEntity= EstadoCampana.class)
	@JoinColumn(name="estado_campana_id")
	private EstadoCampana estadoCampana;
		
	@ManyToOne(optional = false)
	@JoinColumn(name="campana_id")
	@JsonIgnore
	private Campana campana;
	
	
	public Campana getCampana() {
		return campana;
	}

	public void setCampana(Campana campana) {
		this.campana = campana;
	}

	public SeguimientoCampana(String observacion, Long usuarioId, String matricula, EstadoCampana estadoCampana) {
		super();
		this.matricula = matricula;
		this.observacion = observacion;
		this.usuarioId = usuarioId;
		this.estadoCampana = estadoCampana;
	}
	
	 public SeguimientoCampana() {
		
	}
	 
	 

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Map<String, Object> getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Map<String, Object> empleado) {
		this.empleado = empleado;
	}

	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Map<String, Object> getUsuario() {
		return usuario;
	}
	public void setUsuario(Map<String, Object> usuario) {
		this.usuario = usuario;
	}
	public EstadoCampana getEstadoCampana() {
		return estadoCampana;
	}
	public void setEstadoCampana(EstadoCampana estadoCampana) {
		this.estadoCampana = estadoCampana;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
