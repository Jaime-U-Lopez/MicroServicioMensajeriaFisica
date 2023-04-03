package com.mensajeria.ServicioMensajeria.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Date antiguedad;
    private char tipoSangreRH;

    @Enumerated(EnumType.STRING)
    private TypeEmpleoyerEnum typeEmpleoyer;

    private long celular;
    private String correoElectronico;
    private String direccionResidencia;
    private String ciudad;

    public Employee(long cedula, String name, String lastName, Date antiguedad, char tipoSangreRH, TypeEmpleoyerEnum typeEmpleoyer, long celular, String correoElectronico, String direccionResidencia, String ciudad) {
        super(cedula, name, lastName);
        this.antiguedad = antiguedad;
        this.tipoSangreRH = tipoSangreRH;
        this.typeEmpleoyer = typeEmpleoyer;
        this.celular = celular;
        this.correoElectronico = correoElectronico;
        this.direccionResidencia = direccionResidencia;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public Date getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Date antiguedad) {
        this.antiguedad = antiguedad;
    }

    public char getTipoSangreRH() {
        return tipoSangreRH;
    }

    public void setTipoSangreRH(char tipoSangreRH) {
        this.tipoSangreRH = tipoSangreRH;
    }

    public TypeEmpleoyerEnum getTypeEmpleoyer() {
        return typeEmpleoyer;
    }

    public void setTypeEmpleoyer(TypeEmpleoyerEnum typeEmpleoyer) {
        this.typeEmpleoyer = typeEmpleoyer;
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
