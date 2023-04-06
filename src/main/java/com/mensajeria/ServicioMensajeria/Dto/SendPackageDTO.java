package com.mensajeria.ServicioMensajeria.Dto;

import com.mensajeria.ServicioMensajeria.Model.StateSendPackageEnum;
import com.mensajeria.ServicioMensajeria.Model.TypeEmployeeEnum;

import java.io.Serializable;

public class SendPackageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer cedula;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String direccionDestino;
    private String nombrePersonaRecibe;
    private Long celular;
    private Integer valorPaquete;
    private Integer pesoPaquete;
    private Integer numeroGuia;
    private StateSendPackageEnum estadoEnvio;
    private TypeEmployeeEnum  typeEmployee;

    public TypeEmployeeEnum getTypeEmployee() {
        return typeEmployee;
    }

    public void setTypeEmployee(TypeEmployeeEnum typeEmployee) {
        this.typeEmployee = typeEmployee;
    }

    public SendPackageDTO(){};


    public SendPackageDTO(Integer numeroGuia, StateSendPackageEnum estadoEnvio){
        this.numeroGuia=numeroGuia;
        this.estadoEnvio=estadoEnvio;

    }

    public SendPackageDTO(Integer cedula, String ciudadOrigen, String ciudadDestino, String direccionDestino, String nombrePersonaRecibe, Long celular, Integer valorPaquete, Integer pesoPaquete) {
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

    public Integer getValorPaquete() {
        return valorPaquete;
    }

    public void setValorPaquete(Integer valorPaquete) {
        this.valorPaquete = valorPaquete;
    }

    public Integer getPesoPaquete() {
        return pesoPaquete;
    }

    public Integer getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(Integer numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public StateSendPackageEnum getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(StateSendPackageEnum estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public void setPesoPaquete(Integer pesoPaquete) {
        this.pesoPaquete = pesoPaquete;
    }
}
