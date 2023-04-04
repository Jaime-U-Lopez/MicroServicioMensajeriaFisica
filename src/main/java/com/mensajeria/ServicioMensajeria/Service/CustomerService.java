package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Model.Customer;

import java.util.List;

public interface CustomerService {


    Customer create(Customer customer );

    List<Customer> getCustomerAll();

    Customer getCustomer(Integer id);

    Boolean delete(Integer cedula);




}
