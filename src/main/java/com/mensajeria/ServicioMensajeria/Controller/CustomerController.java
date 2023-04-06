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

    @GetMapping("costumers")
    public List<Customer> getCustomerAll(){
        return this.customerServiceImple.getCustomerAll();
    }

    @GetMapping("costumer/{id}")
    public Customer getCustomer(@PathVariable Integer id){
        return this.customerServiceImple.getCustomer(id);
    }



    @PostMapping("customers")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){

        Customer customerCreate = this.customerServiceImple.create(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);

    }




    @DeleteMapping("costumer/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){

        Boolean deleted =this.customerServiceImple.delete(id);

        if (deleted) {
            String messaje = "El empleado con cedula " + id + " fue eliminado con exito !";
            return ResponseEntity.ok(messaje);

        } else {
            String messaje = "El empleado con cedula " + id + " no fue eliminado, valide la cedula ingresada, no  existe en la base de datos";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messaje);
        }


    }



    @PutMapping("customers")
    public ResponseEntity<Customer> Update(@RequestBody Customer customer){

        Customer customerUpdate = this.customerServiceImple.updateCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerUpdate);

    }

}
