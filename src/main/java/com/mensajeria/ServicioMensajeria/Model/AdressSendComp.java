package com.mensajeria.ServicioMensajeria.Model;


import org.springframework.stereotype.Component;


public class AdressSendComp {

    private String ciudadDestino;
    private String ciudadOrigen;
    private String direccion;
    private String ciudad;

    public AdressSendComp(String ciudadDestino, String ciudadOrigen, String direccion, String ciudad) {
        this.ciudadDestino = ciudadDestino;
        this.ciudadOrigen = ciudadOrigen;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }
}
