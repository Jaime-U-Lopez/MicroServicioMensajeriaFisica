package com.mensajeria.ServicioMensajeria.Repository;


import com.mensajeria.ServicioMensajeria.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeReposImple implements EmployeeDAO{


    private EmployeeRepository employeeRepository;

    public EmployeeReposImple(){};

    @Autowired
    public EmployeeReposImple(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.save(employee);

    }

    @Override
    public List<Employee> getEmployeesAll() {

        List<Employee> employeeList = Optional.ofNullable(this.employeeRepository.findAll())
                .map(customers -> customers.stream().collect(Collectors.toList()))
                .orElse(Collections.emptyList());

        return employeeList;

    }

    @Override
    public Employee getEmployee( Integer id) {

            Optional<Employee> employee = this.employeeRepository.findById(id);
            return employee.get();

    }

    @Override
    public Boolean deleteEmployee(Integer id) {
        this.employeeRepository.deleteById(id);
        return true;


    }

    @Override
    public Employee UpdateEmployee(Employee employee) {

        return this.employeeRepository.saveAndFlush(employee);
    }
}
