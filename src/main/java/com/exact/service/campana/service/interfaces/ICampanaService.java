package com.exact.service.campana.service.interfaces;

import com.exact.service.campana.entity.Campana;

public interface ICampanaService {
	Campana guardar(Campana campana);
	Iterable<Campana> listarAll();
}
