package com.exact.service.campana.enumerator;

public enum EstadoItemCampanaEnum {
	
	ENTREGADO(1), 
	REZAGADO(2),
	NO_DISTRIBUIBLE(3),
	FALTANTE(4);
	
	private final int value;
	
    private EstadoItemCampanaEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
