package com.mensajeria.ServicioMensajeria.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 1L;


    @Enumerated(EnumType.STRING)
    private TypeEmployeeEnum typeEmpleoyer;

    private long numeroCelular;
    private String correoElectronico;
    private String direccionResidencia;
    private String ciudad;
    private Date antiguedad;
    @Column(name = "tipo_sangre_RH")
    private String tipoSangreRH;

    public Employee() {
    };




    public Employee(Integer cedula, String name, String lastName, Date antiguedad, String tipoSangreRH, TypeEmployeeEnum typeEmpleoyer, long celular, String correoElectronico, String direccionResidencia, String ciudad) {
        super(cedula, name, lastName);
        this.antiguedad = antiguedad;
        this.tipoSangreRH = tipoSangreRH;
        this.typeEmpleoyer = typeEmpleoyer;
        this.numeroCelular = celular;
        this.correoElectronico = correoElectronico;
        this.direccionResidencia = direccionResidencia;
        this.ciudad = ciudad;
    }


    public Date getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Date antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getTipoSangreRH() {
        return tipoSangreRH;
    }

    public void setTipoSangreRH(String tipoSangreRH) {
        this.tipoSangreRH = tipoSangreRH;
    }

    public TypeEmployeeEnum getTypeEmpleoyer() {
        return typeEmpleoyer;
    }

    public void setTypeEmpleoyer(TypeEmployeeEnum typeEmpleoyer) {
        this.typeEmpleoyer = typeEmpleoyer;
    }

    public long getCelular() {
        return numeroCelular;
    }

    public void setCelular(long numeroCelular) {
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
