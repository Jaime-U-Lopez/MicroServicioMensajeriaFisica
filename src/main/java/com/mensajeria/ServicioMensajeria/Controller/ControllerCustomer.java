package com.mensajeria.ServicioMensajeria.Controller;

import com.mensajeria.ServicioMensajeria.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-mensajeria/v1/")
public class ControllerCustomer {

    private ServicerCustomer servicerCustomer;

    @Autowired
    public ControllerCustomer(ServicerCustomer servicerCustomer){
        this.servicerCustomer=servicerCustomer;

    }

    @PostMapping("customer")
    public boolean createCustomer(@RequestBody Customer customer) {
        return this.servicerCustomer.createCustomer(customer);
    }

    @GetMapping("customer/{id}")
    public Customer getCustomer(@PathVariable String id) {
       return this.servicerCustomer.getCustomer(id);
    }


    @GetMapping("customers-all")
    public List<Customer> getCustomersAll() {
        return this.servicerCustomer.getCustomerAll();
    }


    @DeleteMapping("customer/{id}")
    public boolean deleteCustomer(@PathVariable String id) {
        return this.servicerCustomer.deleteCustomer(id);

    }

    @PutMapping("customer/{id}")
    public boolean updateCustomer(@RequestBody Customer customer , @PathVariable String id ){

        return this.servicerCustomer.updateCustomer(customer, id);
}

}
