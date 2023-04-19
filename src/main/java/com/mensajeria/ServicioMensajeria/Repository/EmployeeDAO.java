package com.mensajeria.ServicioMensajeria.Repository;

import com.mensajeria.ServicioMensajeria.Model.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee create(Employee employee );
    List<Employee> getEmployeesAll();

    Employee getEmployee( Integer id);

    Boolean deleteEmployee( Integer Id);

    Employee UpdateEmployee( Employee employee );

}
