package com.mensajeria.ServicioMensajeria.Repository;


import com.mensajeria.ServicioMensajeria.Dto.CustomerDTO;
import com.mensajeria.ServicioMensajeria.Model.Customer;

import java.util.List;

public interface CustomerDAO {


    public CustomerDTO create(CustomerDTO customerDTO);

    public boolean delete(Integer cedula);

    public List<Customer> getCustomersAll();

    public Customer getCustomer(Integer cedula);

    public boolean UpdateCustomer(Customer customer);



}
