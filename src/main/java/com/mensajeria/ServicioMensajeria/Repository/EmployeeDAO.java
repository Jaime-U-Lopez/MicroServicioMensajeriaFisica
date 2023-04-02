package com.mensajeria.ServicioMensajeria.Repository;

import com.mensajeria.ServicioMensajeria.Dto.EmployeeDTO;

import java.util.List;

public interface EmployeeDAO {

    EmployeeDTO create(EmployeeDTO employeeDTO );
    List<EmployeeDTO> getEmployeesAll();

    EmployeeDTO getEmployee();

    Boolean deleteEmployee( Integer Id);


}
