package com.mensajeria.ServicioMensajeria.Model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(position = 0)
    @Id
    private Integer cedula;
    @ApiModelProperty(position = 1)
    private String name;
    @ApiModelProperty(position = 2)
    private String lastName;
    @ApiModelProperty(position = 3)
    private long numeroCelular;
    @ApiModelProperty(position = 4)
    private String correoElectronico;
    @ApiModelProperty(position = 5)
    private String direccionResidencia;
    @ApiModelProperty(position = 6)
    private String ciudad;


    public Person() {
    }

    ;

    @Autowired
    public Person(Integer cedula, String name, String lastName, long numeroCelular, String correoElectronico, String direccionResidencia, String ciudad) {
        this.cedula = cedula;
        this.name = name;
        this.lastName = lastName;
        this.numeroCelular = numeroCelular;
        this.correoElectronico = correoElectronico;
        this.direccionResidencia = direccionResidencia;
        this.ciudad = ciudad;
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

    public long getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(long numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}

