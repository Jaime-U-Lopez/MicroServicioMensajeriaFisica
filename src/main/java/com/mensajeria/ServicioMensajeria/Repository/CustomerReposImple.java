package com.mensajeria.ServicioMensajeria.Repository;


import com.mensajeria.ServicioMensajeria.Dto.CustomerDTO;
import com.mensajeria.ServicioMensajeria.Exception.ExcepcionCustomer;
import com.mensajeria.ServicioMensajeria.Exception.ExcepcionEmployee;
import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Util.MapperObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class CustomerReposImple implements CustomerDAO {


    public CustomerRepository customerRepository;
    public MapperObject mapperObject;

    @Autowired
    public CustomerReposImple(CustomerRepository customerRepository , MapperObject mapperObject) {
        this.customerRepository = customerRepository;
        this.mapperObject=mapperObject;
    }

    public CustomerReposImple() {
    }


    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {

        Customer customer = mapperObject.dtoToEntity(customerDTO);
         this.customerRepository.save(customer);
        return customerDTO;
    }


    @Override
    public boolean delete(Integer cedula) {

        this.customerRepository.deleteById(cedula);;
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
    public Customer getCustomer(Integer id) throws RuntimeException {

        Optional<Customer> customer= this.customerRepository.findById(id);
        if (!customer.isPresent()) {
            return null;
        }
        return customer.get();
    }

    @Override
    public boolean UpdateCustomer(Customer customer) {

        this.customerRepository.saveAndFlush(customer);
        return true;
    }
}
