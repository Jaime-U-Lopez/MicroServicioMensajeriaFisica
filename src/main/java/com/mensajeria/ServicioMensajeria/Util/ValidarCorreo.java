package com.mensajeria.ServicioMensajeria.Util;

import java.util.regex.Pattern;

public class ValidarCorreo {

    public static boolean esCorreoValido(String correo) {
        // Expresión regular para validar correos electrónicos
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // Compilar la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);

        //validar el correo electronico
        return pattern.matcher(correo).matches();
    }

}
