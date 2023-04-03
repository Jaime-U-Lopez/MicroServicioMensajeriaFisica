package com.mensajeria.ServicioMensajeria.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adressSends")
public class AdressSendComp  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ciudadDestino;
    private String ciudadOrigen;
    private String direccion;
    private String ciudad;
    @Autowired
    public AdressSendComp(String ciudadDestino, String ciudadOrigen, String direccion, String ciudad) {
        this.ciudadDestino = ciudadDestino;
        this.ciudadOrigen = ciudadOrigen;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }
}
