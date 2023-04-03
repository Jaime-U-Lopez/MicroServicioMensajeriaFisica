package com.mensajeria.ServicioMensajeria.Repository;


import com.mensajeria.ServicioMensajeria.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerImpleRepos implements CustomerDAO {



    public CustomerRepository customerRepository;

    @Autowired
    public CustomerImpleRepos(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public CustomerImpleRepos(){};

    @Override
    public boolean create(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Customer> getCustomersAll() {
        return null;
    }

    @Override
    public Customer getCustomer(Integer id) {
        return null;
    }

    @Override
    public boolean UpdateCustomer(Customer customer) {
        return false;
    }
}
