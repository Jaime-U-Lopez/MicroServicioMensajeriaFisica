package com.mensajeria.ServicioMensajeria.Model;

public enum TypeEmpleoyerEnum {
    ;

    private final String CONTADOR;
    private  final String REPARTIDOR;
    private final String COORDINADOR;


    TypeEmpleoyerEnum(String CONTADOR, String REPARTIDOR, String COORDINADOR) {
        this.CONTADOR = CONTADOR;
        this.REPARTIDOR = REPARTIDOR;
        this.COORDINADOR = COORDINADOR;
    }
}
