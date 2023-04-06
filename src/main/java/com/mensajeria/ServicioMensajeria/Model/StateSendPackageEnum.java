package com.mensajeria.ServicioMensajeria.Model;

public enum StateSendPackageEnum {


    RECIBIDO("RECIBIDO"),
    RUTA("RUTA"),
    ENTREGADO("ENTREGADO");

    private final String name;

    StateSendPackageEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }




}
