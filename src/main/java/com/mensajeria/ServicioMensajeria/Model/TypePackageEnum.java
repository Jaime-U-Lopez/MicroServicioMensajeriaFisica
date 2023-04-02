package com.mensajeria.ServicioMensajeria.Model;

public enum TypePackageEnum {
    ;

    private final String LIVIANO;
    private  final String GRANDE;
    private  final String MEDIANO;

    TypePackageEnum(String LIVIANO, String GRANDE, String MEDIANO) {
        this.LIVIANO = LIVIANO;
        this.GRANDE = GRANDE;
        this.MEDIANO = MEDIANO;
    }
}
