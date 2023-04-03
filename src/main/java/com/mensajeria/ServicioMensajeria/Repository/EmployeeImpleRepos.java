package com.mensajeria.ServicioMensajeria.Repository;


import com.mensajeria.ServicioMensajeria.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeImpleRepos  implements EmployeeDAO{


    private EmployeeRepository employeeRepository;


    public EmployeeImpleRepos(){};

    @Autowired
    public EmployeeImpleRepos(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> getEmployeesAll() {
        return null;
    }

    @Override
    public Employee getEmployee( Integer id) {
        return null;
    }

    @Override
    public Boolean deleteEmployee(Integer Id) {
        return null;
    }

    @Override
    public Employee UpdateEmployee(Employee employee) {
        return null;
    }
}
