package com.exact.service.campana.entity;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "campana")
@Inheritance(strategy = InheritanceType.JOINED)
public class Campana implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "campana_id")
	private Long id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private boolean regulatorio;

	@Column(name = "requiere_gps", nullable = false)
	private boolean requiereGps;

	@Column(name = "cantidad_lima", nullable = false)
	private Long cantidadLima;

	@Column(name = "cantidad_provincia", nullable = false)
	private Long cantidadProvincia;

	@Column(name = "requiere_georreferencia", nullable = false)
	private boolean requiereGeorreferencia;

	@Column(name = "autorizado", nullable = false)
	private boolean autorizado;

	@Column(name = "plazo_id", nullable = false)
	private Long plazoId;

	@Transient
	private Map<String, Object> plazo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tipo_destino_id")
	private TipoDestino tipoDestino;

	@Column(name = "buzon_id", nullable = false)
	private Long buzonId;

	@Transient
	private Map<String, Object> buzon;

	@Column(name = "tipo_documento_id", nullable = false)
	private Long tipoDocumentoId;

	@Transient
	private Map<String, Object> tipoDocumento;

	@Column(name = "ruta_autorizacion")
	private String rutaAutorizacion;

	private String observacion;

	@Column(name = "proveedor_id")
	private Long proveedorId;

	@Transient
	private Map<String, Object> proveedor;
	
	@OneToOne(mappedBy = "campana", cascade=CascadeType.ALL)
	private AccionRestosCargosCampana accionRestosCargosCampana;
	
	@OneToOne(mappedBy = "campana", cascade=CascadeType.ALL)
	private AccionRestosRezagosCampana accionRestosRezagosCampana;
	
	@OneToOne(mappedBy = "campana", cascade=CascadeType.ALL)
	private Auspiciador auspiciador;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="campana_id")
	private Set<ItemCampana> itemsCampana;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="campana_id")
	private Set<SeguimientoCampana> seguimientosCampana;
	

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


	public boolean isRegulatorio() {
		return regulatorio;
	}


	public void setRegulatorio(boolean regulatorio) {
		this.regulatorio = regulatorio;
	}


	public boolean isRequiereGps() {
		return requiereGps;
	}


	public void setRequiereGps(boolean requiereGps) {
		this.requiereGps = requiereGps;
	}


	public Long getCantidadLima() {
		return cantidadLima;
	}


	public void setCantidadLima(Long cantidadLima) {
		this.cantidadLima = cantidadLima;
	}


	public Long getCantidadProvincia() {
		return cantidadProvincia;
	}


	public void setCantidadProvincia(Long cantidadProvincia) {
		this.cantidadProvincia = cantidadProvincia;
	}


	public boolean isRequiereGeorreferencia() {
		return requiereGeorreferencia;
	}


	public void setRequiereGeorreferencia(boolean requiereGeorreferencia) {
		this.requiereGeorreferencia = requiereGeorreferencia;
	}


	public boolean isAutorizado() {
		return autorizado;
	}


	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}


	public Long getPlazoId() {
		return plazoId;
	}


	public void setPlazoId(Long plazoId) {
		this.plazoId = plazoId;
	}


	public Map<String, Object> getPlazo() {
		return plazo;
	}


	public void setPlazo(Map<String, Object> plazo) {
		this.plazo = plazo;
	}


	public TipoDestino getTipoDestino() {
		return tipoDestino;
	}


	public void setTipoDestino(TipoDestino tipoDestino) {
		this.tipoDestino = tipoDestino;
	}


	public Long getBuzonId() {
		return buzonId;
	}


	public void setBuzonId(Long buzonId) {
		this.buzonId = buzonId;
	}


	public Map<String, Object> getBuzon() {
		return buzon;
	}


	public void setBuzon(Map<String, Object> buzon) {
		this.buzon = buzon;
	}


	public Long getTipoDocumentoId() {
		return tipoDocumentoId;
	}


	public void setTipoDocumentoId(Long tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}


	public Map<String, Object> getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(Map<String, Object> tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public String getRutaAutorizacion() {
		return rutaAutorizacion;
	}


	public void setRutaAutorizacion(String rutaAutorizacion) {
		this.rutaAutorizacion = rutaAutorizacion;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public Long getProveedorId() {
		return proveedorId;
	}


	public void setProveedorId(Long proveedorId) {
		this.proveedorId = proveedorId;
	}


	public Map<String, Object> getProveedor() {
		return proveedor;
	}


	public void setProveedor(Map<String, Object> proveedor) {
		this.proveedor = proveedor;
	}


	public Set<ItemCampana> getItemsCampana() {
		return itemsCampana;
	}


	public void setItemsCampana(Set<ItemCampana> itemsCampana) {
		this.itemsCampana = itemsCampana;
	}


	public Set<SeguimientoCampana> getSeguimientosCampana() {
		return seguimientosCampana;
	}


	public void setSeguimientosCampana(Set<SeguimientoCampana> seguimientosCampana) {
		this.seguimientosCampana = seguimientosCampana;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
