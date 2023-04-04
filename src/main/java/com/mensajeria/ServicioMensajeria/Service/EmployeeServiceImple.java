package com.mensajeria.ServicioMensajeria.Service;


import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Model.Employee;
import com.mensajeria.ServicioMensajeria.Repository.EmployeeReposImple;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImple implements EmployeeService {


    private EmployeeReposImple employeeReposImple;

    public EmployeeServiceImple(EmployeeReposImple employeeReposImple) {
        this.employeeReposImple = employeeReposImple;
    }

    public EmployeeServiceImple() {
    }


    @Override
    public Employee create(Employee employee) {
        return this.employeeReposImple.create(employee);
    }

    @Override
    public List<Employee> getEmployeeAll() {

        return this.employeeReposImple.getEmployeesAll();
    }

    @Override
    public Employee getEmployee(Integer id) {

        Optional<Employee> employee= Optional.ofNullable(this.employeeReposImple.getEmployee(id));

        if (!employee.isPresent()){
            throw  new RuntimeException("The employee not existed in database");
        }

        return employee.get();




    }

    @Override
    public Boolean delete(Integer cedula) {

        Optional<Boolean> customer = Optional.ofNullable(this.employeeReposImple.deleteEmployee(cedula));

        if (!customer.isPresent()) {
            throw new RuntimeException("The Employee  not existed in database");
        }

        return true;


    }
}
