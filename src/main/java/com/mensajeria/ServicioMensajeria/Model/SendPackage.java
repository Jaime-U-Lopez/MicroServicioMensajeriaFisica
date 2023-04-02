package com.mensajeria.ServicioMensajeria.Model;

import javax.persistence.Entity;


@Entity
public class SendPackage {


    private char numeroGuia;
    private Customer customer;
    private Packages packages;
    private int valorEnvio;
    private long celularPersonaRecibe;
    private String nombrePersonaRecibe;
    private String horaEntrega;
    private StateSendPackageEnum estadoEnvio;
    private AdressSendComp adress_send;

    public SendPackage(char numeroGuia, Customer customer, Packages packages, int valorEnvio, long celularPersonaRecibe, String nombrePersonaRecibe, String horaEntrega, StateSendPackageEnum estadoEnvio, AdressSendComp adress_send) {
        this.numeroGuia = numeroGuia;
        this.customer = customer;
        this.packages = packages;
        this.valorEnvio = valorEnvio;
        this.celularPersonaRecibe = celularPersonaRecibe;
        this.nombrePersonaRecibe = nombrePersonaRecibe;
        this.horaEntrega = horaEntrega;
        this.estadoEnvio = estadoEnvio;
        this.adress_send = adress_send;
    }
}


