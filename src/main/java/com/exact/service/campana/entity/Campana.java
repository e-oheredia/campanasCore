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
	
	@OneToMany
	@JoinColumn(name="campana_id")
	private Set<ItemCampana> itemsCampana;
	
	@OneToMany
	@JoinColumn(name="campana_id")
	private Set<SeguimientoCampana> seguimientosCampana;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
