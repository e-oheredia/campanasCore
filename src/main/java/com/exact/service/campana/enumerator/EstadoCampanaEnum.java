package com.exact.service.campana.enumerator;

public enum EstadoCampanaEnum {
	CREADO(1);
		
	private final int value;
    private EstadoCampanaEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
