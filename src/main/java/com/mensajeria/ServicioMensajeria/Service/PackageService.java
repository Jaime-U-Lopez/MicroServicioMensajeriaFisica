package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Model.Employee;
import com.mensajeria.ServicioMensajeria.Model.Packages;

import java.util.List;

public interface PackageService {


    Packages create(Packages packages );

    List<Packages> getCustomerAll();

    Packages getCustomer(Integer id);

    Boolean delete(Integer cedula);


}
