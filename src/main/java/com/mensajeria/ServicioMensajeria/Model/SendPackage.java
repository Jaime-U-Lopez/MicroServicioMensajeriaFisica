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
    private int valorEnvio;
    private long celularPersonaRecibe;
    private String nombrePersonaRecibe;
    private String horaEntrega;

    @Enumerated(EnumType.STRING)
    private StateSendPackageEnum estadoEnvio;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adressSendComp")
    @JsonIgnoreProperties("sendPackage")
    private AdressSendComp adress_send;

    public SendPackage(Integer numeroGuia, Customer customer, Packages packages, int valorEnvio, long celularPersonaRecibe, String nombrePersonaRecibe, String horaEntrega, StateSendPackageEnum estadoEnvio, AdressSendComp adress_send) {
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


