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
    @Enumerated(EnumType.STRING)
    private TypePackageEnum typePackage;
    private Integer pesoPaquete;
    private Integer valorPaquete;

    public Packages() {
    }


    public Packages(TypePackageEnum typePackage, Integer pesoPaquete, Integer valorPaquete) {

        this.typePackage = typePackage;
        this.pesoPaquete = pesoPaquete;
        this.valorPaquete = valorPaquete;
    }


    public static TypePackageEnum tipoPaquete(Integer peso ){

        if (peso < 0) {
            throw new IllegalArgumentException("El Peso del package debe ser positivo");
        } else if (peso < 2) {
            return TypePackageEnum.LIVIANO;
        } else if (peso >2 && peso <5) {
            return TypePackageEnum.GRANDE;
        } else {
            return TypePackageEnum.MEDIANO;
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getValorPaquete() {
        return valorPaquete;
    }

    public void setValorPaquete(Integer valorPaquete) {
        this.valorPaquete = valorPaquete;
    }
}
