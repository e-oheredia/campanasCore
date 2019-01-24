package com.exact.service.campana.utils;

import java.util.List;

import com.exact.service.campana.entity.Campana;

public class CampanaUtils {

	public static void tieneEstadoPermitido(Campana campana, List<Long> idsEstadosPermitidos) throws IllegalAccessException {

		if (!idsEstadosPermitidos.stream().anyMatch(idEstadoPermitido -> idEstadoPermitido.longValue() == campana
				.getUltimoSeguimientoCampana().getEstadoCampana().getId().longValue())) {
			throw new IllegalAccessException("No tiene permitido realizar la operación");
		}
	}

}
