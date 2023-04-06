package com.mensajeria.ServicioMensajeria.Model;

public  enum TypePackageEnum {

    LIVIANO("LIVIANO"),
    MEDIANO("MEDIANO"),
    GRANDE("GRANDE");

    private final String name;

    TypePackageEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



}
