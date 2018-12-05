package com.exact.service.campana.service.interfaces;

import com.exact.service.campana.entity.Campana;

public interface ICampanaService {

	
	Iterable<Campana> listarCampanasPorEstado(Long estadoId);

	Campana guardar(Campana campana, Long usuarioId);

}
