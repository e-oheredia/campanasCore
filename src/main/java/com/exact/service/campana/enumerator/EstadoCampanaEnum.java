package com.exact.service.campana.enumerator;

public enum EstadoCampanaEnum {

	CREADO(1), 
	ASIGNADO(2),
	GEOREFERENCIADA(3),
	GEOREFERENCIADA_Y_MODIFICADA(4),
	GEOREFERENCIADA_Y_CONFIRMADA(5),
	COTIZADA(6),
	CONFORMIDAD_ADJUNTADA(7),
	CONFORMIDAD_ACEPTADA(8),
	CONFORMIDAD_DENEGADA(9),
	MUESTRA_SOLICITADA(10),
	MUESTRA_ADJUNTADA(11),
	MUESTRA_ACEPTADA(12),
	MUESTRA_DENEGADA(13),
	IMPRESION_INICIADA(14),
	CAMPANA_POR_RECOGER(15),
	GUIA_ADJUNTADA(16),
	GUIA_VERIFICADA(17),
	GUIA_DENEGADA(18),
	DISTRIBUCION_INICIADA(19),
	REPORTE_ADJUNTADO(20);
	

		
	private final int value;
    private EstadoCampanaEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
