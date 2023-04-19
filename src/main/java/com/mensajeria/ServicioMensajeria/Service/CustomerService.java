package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Dto.CustomerDTO;
import com.mensajeria.ServicioMensajeria.Model.Customer;

import java.util.List;

public interface CustomerService {


    CustomerDTO create(CustomerDTO customerDTO );

    List<Customer> getCustomerAll();

    Customer getCustomer(Integer id);

    Boolean delete(Integer cedula);

    Customer updateCustomer(Customer customer);

}
