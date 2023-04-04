package com.mensajeria.ServicioMensajeria.Controller;

import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Service.CustomerServiceImple;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mensajeria/v1/")
@Api(value = "Customer")
public class CustomerController {



    private CustomerServiceImple customerServiceImple;

    @Autowired
    public CustomerController(CustomerServiceImple customerServiceImple) {
        this.customerServiceImple = customerServiceImple;
    }

    @GetMapping("costumer")
    public List<Customer> getCustomerAll(){
        return this.customerServiceImple.getCustomerAll();
    }

    @GetMapping("costumer/{id}")
    public Customer getCustomer(@PathVariable Integer id){
        return this.customerServiceImple.getCustomer(id);
    }



    @PostMapping("customer")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){

        Customer customerCreate = this.customerServiceImple.create(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);

    }


    @DeleteMapping("customer/{id}")
    public Boolean delete(@PathVariable Integer cedula ){

        return this.customerServiceImple.delete(cedula);
    }


}
