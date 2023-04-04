package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Model.Employee;

import java.util.List;

public interface EmployeeService {



    Employee create(Employee employee );

    List<Employee> getEmployeeAll();

    Employee getEmployee(Integer id);

    Boolean delete(Integer cedula);




}
