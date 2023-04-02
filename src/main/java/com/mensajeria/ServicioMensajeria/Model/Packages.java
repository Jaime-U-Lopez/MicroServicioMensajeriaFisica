package com.mensajeria.ServicioMensajeria.Model;


import javax.persistence.Entity;

@Entity
public class Packages {

    private int id;
    private  static int contadorPaquetes;
    private TypePackageEnum typePackage;
    private int pesoPaquete;
    private int valorPaquete;

    public Packages(int id, TypePackageEnum typePackage, int pesoPaquete, int valorPaquete) {
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

    public int getPesoPaquete() {
        return pesoPaquete;
    }

    public void setPesoPaquete(int pesoPaquete) {
        this.pesoPaquete = pesoPaquete;
    }

    public int getValorPaquete() {
        return valorPaquete;
    }

    public void setValorPaquete(int valorPaquete) {
        this.valorPaquete = valorPaquete;
    }
}
