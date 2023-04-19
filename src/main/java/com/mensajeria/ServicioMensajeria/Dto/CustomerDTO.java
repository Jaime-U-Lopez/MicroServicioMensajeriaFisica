package com.mensajeria.ServicioMensajeria.Dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
public class CustomerDTO  implements Serializable {


    @ApiModelProperty(position = 0)
    private Integer  cedula;
    @ApiModelProperty(position = 1)
    private String name;
    @ApiModelProperty(position = 2)
    private String lastName;
    @ApiModelProperty(position = 4)
    private String correoElectronico;
    @ApiModelProperty(position = 6)
    private String ciudad;
    @ApiModelProperty(position = 3)
    private long numeroCelular;
    @ApiModelProperty(position = 5)
    private String direccionResidencia;

    public CustomerDTO(Integer cedula, String name, String lastName, String correoElectronico, String ciudad, long numeroCelular, String direccionResidencia) {
        this.cedula = cedula;
        this.name = name;
        this.lastName = lastName;
        this.correoElectronico = correoElectronico;
        this.ciudad = ciudad;
        this.numeroCelular = numeroCelular;
        this.direccionResidencia = direccionResidencia;
    }




    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public long getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(long numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }
}
