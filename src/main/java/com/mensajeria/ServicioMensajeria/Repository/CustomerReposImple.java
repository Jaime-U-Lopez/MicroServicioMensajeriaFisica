package com.mensajeria.ServicioMensajeria.Repository;


import com.mensajeria.ServicioMensajeria.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class CustomerReposImple implements CustomerDAO {


    public CustomerRepository customerRepository;

    @Autowired
    public CustomerReposImple(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerReposImple() {
    }



    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public boolean delete(Integer id) {
        customerRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Customer> getCustomersAll() {

        List<Customer> customerList = Optional.ofNullable(this.customerRepository.findAll())
                .map(customers -> customers.stream().collect(Collectors.toList()))
                .orElse(Collections.emptyList());

        return customerList;

    }

    @Override
    public Customer getCustomer(Integer id) {

        try {
            Optional<Customer> cliente = this.customerRepository.findById(id);
            return cliente.get();
        } catch (Exception e) {
            throw new RuntimeException("El cliente no existe en la base de datos");

        }

    }

    @Override
    public boolean UpdateCustomer(Customer customer) {
        return false;
    }
}
