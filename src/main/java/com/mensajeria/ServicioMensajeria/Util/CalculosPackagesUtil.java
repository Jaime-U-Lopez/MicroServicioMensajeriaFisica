package com.mensajeria.ServicioMensajeria.Util;

import com.mensajeria.ServicioMensajeria.Model.TypePackageEnum;
import org.springframework.beans.factory.annotation.Autowired;

public class CalculosPackagesUtil {

    private TypePackageEnum typePackageEnum;

    public CalculosPackagesUtil(TypePackageEnum typePackageEnum) {
        this.typePackageEnum = typePackageEnum;
    }


    public static String tipoPaquete(Integer peso ){

        if (peso < 0) {
            throw new IllegalArgumentException("El Peso del package debe ser positivo");
        } else if (peso < 2) {
             return "LIVIANO";
        } else if (peso >2 && peso <5) {
            return "MEDIANO";
        } else {
            return "GRANDE";
        }
    }

    public static Integer valorEnvio(String typePackage){

        if (typePackage == null ) {
            throw new IllegalArgumentException("El Peso del package debe ser positivo");
        } else if (typePackage.equals("GRANDE")) {
            return 50000;
        } else if (typePackage.equals("MEDIANO")) {
            return 40000;
        }else if (typePackage.equals("LIVIANO")) {
            return 30000;
        }else {
            return 0;
        }
    }


}
