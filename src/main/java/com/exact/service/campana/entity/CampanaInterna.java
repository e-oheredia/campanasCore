package com.exact.service.campana.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "campana_interna")
public class CampanaInterna extends Campana {
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tipo_agrupado_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private TipoAgrupado tipoAgrupado;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
