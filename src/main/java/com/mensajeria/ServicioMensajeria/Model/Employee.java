package com.mensajeria.ServicioMensajeria.Model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 1L;


    @Enumerated(EnumType.STRING)
    private TypeEmployeeEnum typeEmpleoyer;

    private Date antiguedad;
    @Column(name = "tipo_sangre_RH")
    private String tipoSangreRH;

    public Employee() {
    };

    @Autowired
    public Employee(Integer cedula, String name, String lastName, long numeroCelular, String correoElectronico, String direccionResidencia, String ciudad, TypeEmployeeEnum typeEmpleoyer, Date antiguedad, String tipoSangreRH) {
        super(cedula, name, lastName, numeroCelular, correoElectronico, direccionResidencia, ciudad);
        this.typeEmpleoyer = typeEmpleoyer;
        this.antiguedad = antiguedad;
        this.tipoSangreRH = tipoSangreRH;
    }

    public TypeEmployeeEnum getTypeEmpleoyer() {
        return typeEmpleoyer;
    }

    public void setTypeEmpleoyer(TypeEmployeeEnum typeEmpleoyer) {
        this.typeEmpleoyer = typeEmpleoyer;
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
}
