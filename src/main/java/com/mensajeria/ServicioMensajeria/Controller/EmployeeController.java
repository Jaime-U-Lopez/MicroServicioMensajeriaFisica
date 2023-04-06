package com.mensajeria.ServicioMensajeria.Controller;


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

    @PostMapping("employees")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {

        Employee employeeCreate = this.employeeServiceImple.create(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeCreate);

    }

    @GetMapping("employees")
    public List<Employee> getEmployeeAll() {
        return this.employeeServiceImple.getEmployeeAll();
    }

    @GetMapping("employees/{id}")
    public Employee getCustomer(@PathVariable Integer id) {
        return this.employeeServiceImple.getEmployee(id);
    }




    @DeleteMapping("employees/{cedula}")
    public ResponseEntity<String> delete(@PathVariable Integer cedula) {

        Boolean deleted = this.employeeServiceImple.delete(cedula);

        if (deleted) {
            String messaje = "El empleado con cedula " + cedula + " fue eliminado con exito !";
            return ResponseEntity.ok(messaje);

        } else {
            String messaje = "El empleado con cedula " + cedula + " no fue eliminado, valide la cedula ingresada, no  existe en la base de datos";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messaje);
        }


    }


    @PutMapping("employees")
        public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee){

        Employee empleado= this.employeeServiceImple.updateEmployee(employee);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(empleado);

    }

}
