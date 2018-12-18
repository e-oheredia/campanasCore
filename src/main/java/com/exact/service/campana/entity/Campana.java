package com.exact.service.campana.entity;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "campana") 
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

	@Column(name = "requiere_georreferencia", nullable = false)
	private boolean requiereGeorreferencia;

	@Column(name = "autorizado", nullable = false)
	private boolean autorizado;

	@Column(name = "plazo_id", nullable = false)
	@JsonIgnore
	private Long plazoId;

	@Transient
	private Map<String, Object> plazo;

	@ManyToOne
	@JoinColumn(name = "tipo_destino_id")
	private TipoDestino tipoDestino;

	@Column(name = "buzon_id", nullable = false)
	@JsonIgnore
	private Long buzonId;

	@Transient
	private Map<String, Object> buzon;

	@Column(name = "tipo_documento_id", nullable = false)
	@JsonIgnore
	private Long tipoDocumentoId;

	@Transient
	private Map<String, Object> tipoDocumento;

	@Column(name = "ruta_autorizacion")
	private String rutaAutorizacion;

	private String observacion;

	@Column(name = "proveedor_id", nullable=true)
	@JsonIgnore
	private Long proveedorId;

	@Transient
	private Map<String, Object> proveedor;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="accion_restos_cargos_campana_id")
	private AccionRestosCargosCampana accionRestosCargosCampana;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="accion_restos_rezagos_campana_id")
	private AccionRestosRezagosCampana accionRestosRezagosCampana;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="auspiciador_id")
	private Auspiciador auspiciador;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="campana_id")
	private Set<ItemCampana> itemsCampana;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="campana_id")
	private Set<SeguimientoCampana> seguimientosCampana;
	
	@ManyToMany
	@JoinTable(
			name="tipo_agrupado_campana", 
			joinColumns=@JoinColumn(name="campana_id"), 
			inverseJoinColumns=@JoinColumn(name="tipo_agrupado_id"))	
	private Set<TipoAgrupado> tiposAgrupado;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "proveedor_impresion_id", nullable=true)
	private ProveedorImpresion proveedorImpresion;
	
	@ManyToOne
	@JoinColumn(name = "tipo_campana", nullable=true)
	private TipoCampana tipoCampana;
	
	
	@Column(name = "costo_campana", nullable=true)
	private Double costoCampana;
	
	@Column(name = "paquete_habilitado_id", nullable=true)
	@JsonIgnore
	private Long paqueteHabilitadoId;
	
	@Transient
	@JsonInclude(value=Include.	NON_NULL)
	private Map<String, Object> paqueteHabilitado;
	
	public Campana() {
		seguimientosCampana = new HashSet<SeguimientoCampana>();
	}	
	
	public TipoCampana getTipoCampana() {
		return tipoCampana;
	}

	public void setTipoCampana(TipoCampana tipoCampana) {
		this.tipoCampana = tipoCampana;
	}

	public Double getCostoCampana() {
		return costoCampana;
	}

	public void setCostoCampana(Double costoCampana) {
		this.costoCampana = costoCampana;
	}

	public void addSeguimientoCampana(SeguimientoCampana seguimientoCampana) {
		seguimientoCampana.setCampana(this);
		seguimientosCampana.add(seguimientoCampana);
	}
	

	public ProveedorImpresion getProveedorImpresion() {
		return proveedorImpresion;
	}


	public void setProveedorImpresion(ProveedorImpresion proveedorImpresion) {
		this.proveedorImpresion = proveedorImpresion;
	}


	public Long getPaqueteHabilitadoId() {
		return paqueteHabilitadoId;
	}


	public void setPaqueteHabilitadoId(Long paqueteHabilitadoId) {
		this.paqueteHabilitadoId = paqueteHabilitadoId;
	}


	public Map<String, Object> getPaqueteHabilitado() {
		return paqueteHabilitado;
	}


	public void setPaqueteHabilitado(Map<String, Object> paqueteHabilitado) {
		this.paqueteHabilitado = paqueteHabilitado;
		this.paqueteHabilitadoId = Long.valueOf(paqueteHabilitado.get("id").toString());
	}
	
	

	public AccionRestosCargosCampana getAccionRestosCargosCampana() {
		return accionRestosCargosCampana;
	}


	public Set<TipoAgrupado> getTiposAgrupado() {
		return tiposAgrupado;
	}

	public void setTiposAgrupado(Set<TipoAgrupado> tiposAgrupado) {
		this.tiposAgrupado = tiposAgrupado;
	}

	public void setAccionRestosCargosCampana(AccionRestosCargosCampana accionRestosCargosCampana) {
		this.accionRestosCargosCampana = accionRestosCargosCampana;
	}


	public AccionRestosRezagosCampana getAccionRestosRezagosCampana() {		
		return accionRestosRezagosCampana;
	}


	public void setAccionRestosRezagosCampana(AccionRestosRezagosCampana accionRestosRezagosCampana) {
		this.accionRestosRezagosCampana = accionRestosRezagosCampana;
	}


	public Auspiciador getAuspiciador() {
		return auspiciador;
	}


	public void setAuspiciador(Auspiciador auspiciador) {
		this.auspiciador = auspiciador;
	}


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
		this.plazoId = Long.valueOf(plazo.get("id").toString());
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
		this.buzonId = Long.valueOf(buzon.get("id").toString());
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
		this.tipoDocumentoId = Long.valueOf(tipoDocumento.get("id").toString());
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
		this.proveedorId = Long.valueOf(proveedor.get("id").toString());
	}


	public Set<ItemCampana> getItemsCampana() {
		return itemsCampana;
	}

	public Iterable<ItemCampana> getItemsCampanaNoEnviables() {
		
		return this.itemsCampana.stream().filter(itemCampana -> !itemCampana.isEnviable()).collect(Collectors.toList());
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
	
	@JsonIgnore
	public SeguimientoCampana getUltimoSeguimientoCampana() {
		return (this.getSeguimientosCampana().stream().max(Comparator.comparing(SeguimientoCampana::getFecha))
		.orElseThrow(NoSuchElementException::new));		
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
