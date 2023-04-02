package com.mensajeria.ServicioMensajeria.Repository;

import java.util.List;

public interface SendPackageDao {


    SendPackageDao create(SendPackageDao sendPackageDao );
    SendPackageDao update(SendPackageDao sendPackageDao);
    Boolean delete(Integer id);
    List<SendPackageDao> getSendPackagesAll();
    SendPackageDao getSendPackage(Integer id);

}
