package com.mensajeria.ServicioMensajeria.Dto;

import java.io.Serializable;

public class SendPackageDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer cedula;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String direccionDestino;
    private String nombrePersonaRecibe;
    private Long celular;
    private Double valorPaquete;
    private Integer pesoPaquete;

    public SendPackageDTO(Integer cedula, String ciudadOrigen, String ciudadDestino, String direccionDestino, String nombrePersonaRecibe, Long celular, Double valorPaquete, Integer pesoPaquete) {
        this.cedula = cedula;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDestino = direccionDestino;
        this.nombrePersonaRecibe = nombrePersonaRecibe;
        this.celular = celular;
        this.valorPaquete = valorPaquete;
        this.pesoPaquete = pesoPaquete;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
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

    public String getNombrePersonaRecibe() {
        return nombrePersonaRecibe;
    }

    public void setNombrePersonaRecibe(String nombrePersonaRecibe) {
        this.nombrePersonaRecibe = nombrePersonaRecibe;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public Double getValorPaquete() {
        return valorPaquete;
    }

    public void setValorPaquete(Double valorPaquete) {
        this.valorPaquete = valorPaquete;
    }

    public Integer getPesoPaquete() {
        return pesoPaquete;
    }

    public void setPesoPaquete(Integer pesoPaquete) {
        this.pesoPaquete = pesoPaquete;
    }
}
