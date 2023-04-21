package com.mensajeria.ServicioMensajeria.Controller;

import com.mensajeria.ServicioMensajeria.Dto.CustomerDTO;
import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Service.CustomerServiceImple;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mensajeria/v1/")
@Api(tags = "customers", description = "Operation for customer management")
public class CustomerController {



    private CustomerServiceImple customerServiceImple;

    @Autowired
    public CustomerController(CustomerServiceImple customerServiceImple) {
        this.customerServiceImple = customerServiceImple;
    }



    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
    @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "Create one customer", notes = "En este endpoind podras realizar la creación de un cliente, de acuerdo a los siguientes parametros ")
    @PostMapping("customers")
    public ResponseEntity<?> create(@RequestBody CustomerDTO customerDTO){
        CustomerDTO customerCreate = this.customerServiceImple.create(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);

    }

    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
    @ApiOperation(value = "Consult all customers", notes = "En este endpoind podras realizar la consulta de todos los clientes en la base de datos ")
    @GetMapping("customers")
    public List<Customer> getCustomerAll(){
        return this.customerServiceImple.getCustomerAll();
    }


    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
    @ApiOperation(value = "Customer id to Consult", notes = "En este endpoind podras realizar la consulta de un cliente por cedula " )
    @GetMapping("customers/{id}")
    public Customer getCustomer(@PathVariable @ApiParam(value = "ID Customer to Consult ", example = "123") Integer id){
        return this.customerServiceImple.getCustomer(id);
    }


    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
    @PreAuthorize("hasRole('WRITE')")
    @ApiOperation(value = "Customer to Update",notes = "En este endpoind podras realizar la actualización  de un cliente  " )
    @PutMapping("customers")
    public ResponseEntity<Customer> Update(@RequestBody @ApiParam(value = "Customer to update   ", example = "123")  Customer customer){

        Customer customerUpdate = this.customerServiceImple.updateCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerUpdate);

    }

    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
    @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "Customer id to Delete ",notes = "En este endpoind podras realizar la eliminación de un cliente por ID" )
    @DeleteMapping("customers/{id}")
    public ResponseEntity<String> delete(@PathVariable @ApiParam(value = "ID Customer to delete  ", example = "123")  Integer id){
        Boolean deleted =this.customerServiceImple.delete(id);
        if (deleted) {
            String messaje = "El empleado con cedula " + id + " fue eliminado con exito !";
            return ResponseEntity.ok(messaje);

        } else {
            String messaje = "El empleado con cedula " + id + " no fue eliminado, valide la cedula ingresada, no  existe en la base de datos";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messaje);
        }


    }


}
