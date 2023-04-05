package com.mensajeria.ServicioMensajeria.Model;


import io.swagger.models.auth.In;
import org.springframework.core.serializer.Serializer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Packages implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private TypePackageEnum typePackage;
    private Integer pesoPaquete;
    private int valorPaquete;

    public Packages(int id, TypePackageEnum typePackage, Integer pesoPaquete, int valorPaquete) {
        this.id = id;
        this.typePackage = typePackage;
        this.pesoPaquete = pesoPaquete;
        this.valorPaquete = valorPaquete;
    }

    public int getId() {
        return id;
    }

    public TypePackageEnum getTypePackage() {
        return typePackage;
    }

    public void setTypePackage(TypePackageEnum typePackage) {
        this.typePackage = typePackage;
    }

    public Integer getPesoPaquete() {
        return pesoPaquete;
    }

    public void setPesoPaquete(Integer pesoPaquete) {
        this.pesoPaquete = pesoPaquete;
    }

    public int getValorPaquete() {
        return valorPaquete;
    }

    public void setValorPaquete(int valorPaquete) {
        this.valorPaquete = valorPaquete;
    }
}
