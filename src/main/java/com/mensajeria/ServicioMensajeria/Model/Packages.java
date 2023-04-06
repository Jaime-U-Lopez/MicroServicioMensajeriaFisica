package com.mensajeria.ServicioMensajeria.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Packages implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String typePackage;
    private Integer pesoPaquete;
    private Integer valorPaquete;

    public Packages() {
    }


    public Packages(String typePackage, Integer pesoPaquete, Integer valorPaquete) {

        this.typePackage = typePackage;
        this.pesoPaquete = pesoPaquete;
        this.valorPaquete = valorPaquete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypePackage() {
        return typePackage;
    }

    public void setTypePackage(String typePackage) {
        this.typePackage = typePackage;
    }

    public Integer getPesoPaquete() {
        return pesoPaquete;
    }

    public void setPesoPaquete(Integer pesoPaquete) {
        this.pesoPaquete = pesoPaquete;
    }

    public Integer getValorPaquete() {
        return valorPaquete;
    }

    public void setValorPaquete(Integer valorPaquete) {
        this.valorPaquete = valorPaquete;
    }
}
