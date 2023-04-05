package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Model.Employee;
import com.mensajeria.ServicioMensajeria.Model.Packages;

import java.util.List;

public interface PackageService {


    Packages create(Packages packages );

    List<Packages> getPackagesAll();

    Packages getPackages(Integer numeroGuia);

    Boolean delete(Integer numeroGuia);


    Packages updatePackages(Packages packages);



}
