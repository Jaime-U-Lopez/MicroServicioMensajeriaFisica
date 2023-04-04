package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Repository.CustomerReposImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CustomerServiceImple implements CustomerService {


    private CustomerReposImple customerReposImple;

    @Autowired
    public CustomerServiceImple(CustomerReposImple customerReposImple) {
        this.customerReposImple = customerReposImple;
    }

    public CustomerServiceImple() {
    }

    @Override
    public Customer create(Customer customer) {

        return this.customerReposImple.create(customer);
    }

    @Override
    public List<Customer> getCustomerAll() {
       return this.customerReposImple.getCustomersAll();
    }

    @Override
    public Customer getCustomer(Integer id) {

        Optional<Customer> customer= Optional.ofNullable(this.customerReposImple.getCustomer(id));

        if (!customer.isPresent()){
            throw  new RuntimeException("The customer not existed in database");
        }

        return customer.get();
    }

    @Override
    public Boolean delete(Integer cedula) {

        Optional<Boolean> customer= Optional.ofNullable(this.customerReposImple.delete(cedula));

        if (!customer.isPresent()){
            throw  new RuntimeException("The customer not existed in database");
        }

        return true;

    }
}
