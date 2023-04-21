package com.mensajeria.ServicioMensajeria.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mensajeria.ServicioMensajeria.Model.AdressSendComp;
import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Model.Packages;
import com.mensajeria.ServicioMensajeria.Model.StateSendPackageEnum;

import javax.persistence.*;
import java.io.Serializable;

public class SendPackageDTOGetAll implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer numeroGuia;
    private Customer customer;
    private Packages packages;
    private long celularPersonaRecibe;
    private String nombrePersonaRecibe;
    private String horaEntrega;
    private Integer valorEnvio;
    private StateSendPackageEnum estadoEnvio;
    private AdressSendComp adressSend;

    public SendPackageDTOGetAll(Integer numeroGuia, Customer customer, Packages packages, long celularPersonaRecibe, String nombrePersonaRecibe, String horaEntrega, Integer valorEnvio, StateSendPackageEnum estadoEnvio, AdressSendComp adressSend) {
        this.numeroGuia = numeroGuia;
        this.customer = customer;
        this.packages = packages;
        this.celularPersonaRecibe = celularPersonaRecibe;
        this.nombrePersonaRecibe = nombrePersonaRecibe;
        this.horaEntrega = horaEntrega;
        this.valorEnvio = valorEnvio;
        this.estadoEnvio = estadoEnvio;
        this.adressSend = adressSend;
    }

    public Integer getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(Integer numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Packages getPackages() {
        return packages;
    }

    public void setPackages(Packages packages) {
        this.packages = packages;
    }

    public long getCelularPersonaRecibe() {
        return celularPersonaRecibe;
    }

    public void setCelularPersonaRecibe(long celularPersonaRecibe) {
        this.celularPersonaRecibe = celularPersonaRecibe;
    }

    public String getNombrePersonaRecibe() {
        return nombrePersonaRecibe;
    }

    public void setNombrePersonaRecibe(String nombrePersonaRecibe) {
        this.nombrePersonaRecibe = nombrePersonaRecibe;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public Integer getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(Integer valorEnvio) {
        this.valorEnvio = valorEnvio;
    }

    public StateSendPackageEnum getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(StateSendPackageEnum estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public AdressSendComp getAdressSend() {
        return adressSend;
    }

    public void setAdressSend(AdressSendComp adressSend) {
        this.adressSend = adressSend;
    }
}
