package com.mensajeria.ServicioMensajeria.Model;

public enum StateSendPackageEnum {
    ;


    private final String recibido;
    private  final String enRuta;
    private final   String entregado;

    StateSendPackageEnum(String recibido, String enRuta, String entregado) {
        this.recibido = recibido;
        this.enRuta = enRuta;
        this.entregado = entregado;
    }
}
