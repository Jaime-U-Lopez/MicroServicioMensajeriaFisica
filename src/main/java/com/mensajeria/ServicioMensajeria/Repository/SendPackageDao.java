package com.mensajeria.ServicioMensajeria.Repository;

import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTO;
import com.mensajeria.ServicioMensajeria.Model.SendPackage;

import java.util.List;

public interface SendPackageDao {


    SendPackage create(SendPackage sendPackage );
    SendPackage update(SendPackage sendPackage);
    Boolean delete(Integer id);
    List<SendPackage> getSendPackagesAll();
    SendPackage getSendPackage(Integer id);

}
