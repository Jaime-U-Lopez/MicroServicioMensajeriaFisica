package com.mensajeria.ServicioMensajeria.Controller;


import com.mensajeria.ServicioMensajeria.Model.Employee;
import com.mensajeria.ServicioMensajeria.Service.EmployeeServiceImple;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mensajeria/v1/")
@Api(tags = "employees", description = "Operation for Employee management")
public class EmployeeController {


    private EmployeeServiceImple employeeServiceImple;

    @Autowired
    public EmployeeController(EmployeeServiceImple employeeServiceImple) {
        this.employeeServiceImple = employeeServiceImple;
    }

    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
    //@PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "Create one Employee",notes = "En este endpoind podras crear un empleado " )
    @PostMapping("employees")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {

        Employee employeeCreate = this.employeeServiceImple.create(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeCreate);
    }

    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
    @ApiOperation(value = "Consult all Employee",notes = "En este endpoind podras realizar la consulta de  todos los empleados " )
    @GetMapping("employees")
    public List<Employee> getEmployeeAll() {
        return this.employeeServiceImple.getEmployeeAll();
    }

    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })

    @ApiOperation(value = "Employee id to Consult",notes = "En este endpoind podras realizar la consulta de un empleado por ID " )
    @GetMapping("employees/{id}")
    public Employee getCustomer(@PathVariable @ApiParam(value = "ID Employee ", example = "123")  Integer id) {
        return this.employeeServiceImple.getEmployee(id);
    }



    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
   // @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "Employee  to Update",notes = "En este endpoind podras realizar la actualización de un empleado" )
    @PutMapping("employees")
    public ResponseEntity<Employee> updateEmployee (@RequestBody @ApiParam(value = "Employee to update ", example = "123")  Employee employee){

        Employee empleado= this.employeeServiceImple.updateEmployee(employee);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(empleado);

    }



    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })

   // @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "Employee Id to delete ",notes = "En este endpoind podras realizar la eliminación de un employee por ID" )
    @DeleteMapping("employees/{cedula}")
    public ResponseEntity<String> delete(@PathVariable @ApiParam(value = "ID Employee ", example = "123")  Integer cedula) {

        Boolean deleted = this.employeeServiceImple.delete(cedula);
        if (deleted) {
            String messaje = "El empleado con cedula " + cedula + " fue eliminado con exito !";
            return ResponseEntity.ok(messaje);
        } else {
            String messaje = "El empleado con cedula " + cedula + " no fue eliminado, valide la cedula ingresada, no  existe en la base de datos";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messaje);
        }
    }

}
