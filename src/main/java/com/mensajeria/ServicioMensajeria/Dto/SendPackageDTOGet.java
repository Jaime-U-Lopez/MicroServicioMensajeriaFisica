package com.mensajeria.ServicioMensajeria.Dto;

import com.mensajeria.ServicioMensajeria.Model.StateSendPackageEnum;

import java.io.Serializable;

public class SendPackageDTOGet implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer cedulaCliente;
    private String nombreRemitente;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String direccionDestino;
    private String nombreRecibe;
    private Long celular;
    private Integer valorDeclaradoPaquete;
    private Integer peso;
    private Integer valorEnvio;
    private StateSendPackageEnum estadoEnvio;


    public SendPackageDTOGet(){};

    public SendPackageDTOGet(Integer cedulaCliente, String nombreRemitente, String ciudadOrigen, String ciudadDestino, String direccionDestino, String nombreRecibe, Long celular, Integer valorDeclaradoPaquete, Integer peso, Integer valorEnvio, StateSendPackageEnum estadoEnvio) {
        this.cedulaCliente = cedulaCliente;
        this.nombreRemitente = nombreRemitente;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDestino = direccionDestino;
        this.nombreRecibe = nombreRecibe;
        this.celular = celular;
        this.valorDeclaradoPaquete = valorDeclaradoPaquete;
        this.peso = peso;
        this.valorEnvio = valorEnvio;
        this.estadoEnvio = estadoEnvio;
    }

    public Integer getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Integer cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreRemitente() {
        return nombreRemitente;
    }

    public void setNombreRemitente(String nombreRemitente) {
        this.nombreRemitente = nombreRemitente;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getNombreRecibe() {
        return nombreRecibe;
    }

    public void setNombreRecibe(String nombreRecibe) {
        this.nombreRecibe = nombreRecibe;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public Integer getValorDeclaradoPaquete() {
        return valorDeclaradoPaquete;
    }

    public void setValorDeclaradoPaquete(Integer valorDeclaradoPaquete) {
        this.valorDeclaradoPaquete = valorDeclaradoPaquete;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
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
}
