package com.mensajeria.ServicioMensajeria.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "sendPackages")
public class SendPackage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "numeroGuia", nullable = false)
    private Integer numeroGuia;
    @ManyToOne
    @JoinColumn(name = "customer")
    @JsonIgnoreProperties("sendPackage")
    private Customer customer;
    @OneToOne
    private Packages packages;
    private long celularPersonaRecibe;
    private String nombrePersonaRecibe;
    private String horaEntrega;
    private Integer valorEnvio;


    @Enumerated(EnumType.STRING)
    private StateSendPackageEnum estadoEnvio;

    @OneToOne
    @JoinColumn(name = "AdressSendComp")
    @JsonIgnoreProperties("sendPackage")
    private AdressSendComp adressSend;

    public SendPackage() {
    }


    public SendPackage(Customer customer, Packages packages, Integer valorEnvio, long celularPersonaRecibe, String nombrePersonaRecibe, StateSendPackageEnum estadoEnvio, AdressSendComp adressSend) {

        this.customer = customer;
        this.packages = packages;
        this.valorEnvio = valorEnvio;
        this.celularPersonaRecibe = celularPersonaRecibe;
        this.nombrePersonaRecibe = nombrePersonaRecibe;
        this.estadoEnvio = estadoEnvio;
        this.adressSend = adressSend;
    }


    public static Integer valorEnvio(String typePackage){

        if (typePackage == null ) {
            throw new IllegalArgumentException("El Peso del package debe ser positivo");
        } else if (typePackage.equals("GRANDE")) {
            return 50000;
        } else if (typePackage.equals("MEDIANO")) {
            return 40000;
        }else if (typePackage.equals("LIVIANO")) {
            return 30000;
        }else {
            return 0;
        }
    }

    public void setValorEnvio(Integer valorEnvio) {
        this.valorEnvio = valorEnvio;
    }


    public void setAdressSend(AdressSendComp adressSend) {
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

    public void setValorEnvio(int valorEnvio) {
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

    public void setAdress_send(AdressSendComp adress_send) {
        this.adressSend = adress_send;
    }
}


