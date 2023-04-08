package com.mensajeria.ServicioMensajeria.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adressSends")
public class AdressSendComp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String ciudadDestino;
    private String ciudadOrigen;
    private String direccion;

    public AdressSendComp(){};

    public AdressSendComp(String ciudadDestino, String ciudadOrigen, String direccion) {
        this.ciudadDestino = ciudadDestino;
        this.ciudadOrigen = ciudadOrigen;
        this.direccion = direccion;

    }



    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
