package com.exact.service.campana.service.interfaces;

import com.exact.service.campana.entity.Campana;

public interface ICampanaService {
	
	Campana guardar(Campana campana, Long usuarioId);
	Campana seleccionarProveedor(Long campanaId, Campana campana, Long usuarioId);
}
