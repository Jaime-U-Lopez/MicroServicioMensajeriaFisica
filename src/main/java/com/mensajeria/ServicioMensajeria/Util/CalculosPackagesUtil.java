package com.mensajeria.ServicioMensajeria.Util;

public class CalculosPackagesUtil {

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
