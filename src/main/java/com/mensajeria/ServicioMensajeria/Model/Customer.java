package com.mensajeria.ServicioMensajeria.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer extends Employee.Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private long celular;
    private String correoElectronico;
    private String direccionResidencia;
    private String ciudad;

    public Customer(long cedula, String name, String lastName, Integer id, long celular, String correoElectronico, String direccionResidencia, String ciudad) {
        super(cedula, name, lastName);
        this.id = id;
        this.celular = celular;
        this.correoElectronico = correoElectronico;
        this.direccionResidencia = direccionResidencia;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }


    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
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
