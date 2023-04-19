package com.mensajeria.ServicioMensajeria.Dto;

import com.mensajeria.ServicioMensajeria.Model.StateSendPackageEnum;
import com.mensajeria.ServicioMensajeria.Model.TypeEmployeeEnum;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SendPackageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(position = 0)
    private Integer cedulaCliente ;
    @ApiModelProperty(position = 5)
    private Long celular;
    @ApiModelProperty(position = 1)
    private String ciudadOrigen;
    @ApiModelProperty(position = 2)
    private String ciudadDestino;
    @ApiModelProperty(position = 3)
    private String direccionDestino;
    @ApiModelProperty(position = 4)
    private String nombrePersonaRecibe;
    @ApiModelProperty(position = 6)
    private Integer valorPaquete;
    @ApiModelProperty(position = 7)
    private Integer pesoPaquete;

    public SendPackageDTO(){};


    public SendPackageDTO(Integer cedula, String ciudadOrigen, String ciudadDestino, String direccionDestino, String nombrePersonaRecibe, Long celular, Integer valorPaquete, Integer pesoPaquete) {
        this.cedulaCliente = cedula;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDestino = direccionDestino;
        this.nombrePersonaRecibe = nombrePersonaRecibe;
        this.celular = celular;
        this.valorPaquete = valorPaquete;
        this.pesoPaquete = pesoPaquete;
    }

    public Integer getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Integer cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
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

    public Integer getValorPaquete() {
        return valorPaquete;
    }

    public void setValorPaquete(Integer valorPaquete) {
        this.valorPaquete = valorPaquete;
    }

    public Integer getPesoPaquete() {
        return pesoPaquete;
    }

    public void setPesoPaquete(Integer pesoPaquete) {
        this.pesoPaquete = pesoPaquete;
    }
}
