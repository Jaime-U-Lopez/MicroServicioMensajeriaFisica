package com.mensajeria.ServicioMensajeria.Model;

public enum TypeEmployeeEnum {

    CONTADOR("CONTADOR"),
    REPARTIDOR("REPARTIDOR"),
    COORDINADOR("COORDINADOR");

    private final String name;

    TypeEmployeeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
