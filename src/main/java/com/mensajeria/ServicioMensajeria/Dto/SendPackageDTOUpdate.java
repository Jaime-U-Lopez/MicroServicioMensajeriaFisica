package com.mensajeria.ServicioMensajeria.Dto;

import com.mensajeria.ServicioMensajeria.Model.StateSendPackageEnum;
import com.mensajeria.ServicioMensajeria.Model.TypeEmployeeEnum;

public class SendPackageDTOUpdate {


    private Integer numeroGuia;
    private Integer cedulaEmpleado;
    private StateSendPackageEnum estadoEnvio;


    public SendPackageDTOUpdate(){};
    public SendPackageDTOUpdate(Integer numeroGuia, Integer cedulaEmpleado, StateSendPackageEnum estadoEnvio) {
        this.numeroGuia = numeroGuia;
        this.cedulaEmpleado = cedulaEmpleado;
        this.estadoEnvio = estadoEnvio;

    }

    public StateSendPackageEnum getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(StateSendPackageEnum estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public Integer getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(Integer numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public Integer getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(Integer cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }
}
