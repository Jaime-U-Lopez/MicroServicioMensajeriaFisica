package com.mensajeria.ServicioMensajeria.Model;

import com.mensajeria.ServicioMensajeria.Exception.ExcepcionCustomer;
import org.mapstruct.InheritConfiguration;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends Person  implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany
    List<SendPackage> sendPackages;

    public Customer(){};

    public Customer(  Integer cedula, String name, String lastName, long numeroCelular, String correoElectronico, String direccionResidencia, String ciudad) {
        super(cedula, name, lastName, numeroCelular, correoElectronico, direccionResidencia, ciudad);
    }

    public List<SendPackage> getSendPackages() {
        return sendPackages;
    }

    public void setSendPackages(List<SendPackage> sendPackages) {
        this.sendPackages = sendPackages;
    }

    public static void validarCliente(Integer pesoPaquete, TypePackageEnum typePackage,  Integer valorPaquete) throws RuntimeException {
        if (typePackage == null || pesoPaquete < 0  || !(pesoPaquete instanceof Integer) || valorPaquete < 0  || !(valorPaquete instanceof Integer)) {
            throw new ExcepcionCustomer("Creacion del  Package  no se puede realizar, no cumple los parametros, de valor Package y peso Package no puede ser menor a cero , o Type Package esta null");
        }

    }

}
