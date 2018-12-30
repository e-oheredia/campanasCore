package com.exact.service.campana.enumerator;

public enum EstadoCampanaEnum {

	CREADO(1), 
	ASIGNADO(2),
	GEOREFERENCIADA(3),
	GEOREFERENCIADA_Y_MODIFICADA(4),
	GEOREFERENCIADA_Y_CONFIRMADA(5),
	COTIZADA(6),
	IMPRESION_SOLICITADA(7);

		
	private final int value;
    private EstadoCampanaEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
