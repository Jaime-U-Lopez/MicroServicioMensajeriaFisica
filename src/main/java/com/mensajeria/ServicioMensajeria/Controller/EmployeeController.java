package com.mensajeria.ServicioMensajeria.Controller;


import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Model.Employee;
import com.mensajeria.ServicioMensajeria.Service.EmployeeServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mensajeria/v1/")
public class EmployeeController {


    private EmployeeServiceImple employeeServiceImple;

    @Autowired
    public EmployeeController(EmployeeServiceImple employeeServiceImple) {
        this.employeeServiceImple = employeeServiceImple;
    }

    @PostMapping("employee")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){

        Employee employeeCreate = this.employeeServiceImple.create(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeCreate);

    }

    @GetMapping("employee")
    public List<Employee> getEmployeeAll(){
        return this.employeeServiceImple.getEmployeeAll();
    }

    @GetMapping("employee/{id}")
    public Employee getCustomer(@PathVariable Integer id){
        return this.employeeServiceImple.getEmployee(id);
    }

    @DeleteMapping("employee/{id}")
    public Boolean delete(@PathVariable Integer cedula ){

        return this.employeeServiceImple.delete(cedula);
    }







}
