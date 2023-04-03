package com.mensajeria.ServicioMensajeria.Repository;

import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTO;

import java.util.List;

public interface SendPackageDao {


    SendPackageDTO create(SendPackageDTO sendPackageDTO );
    SendPackageDTO update(SendPackageDTO sendPackageDTO);
    Boolean delete(Integer id);
    List<SendPackageDTO> getSendPackagesAll();
    SendPackageDTO getSendPackage(Integer id);

}
