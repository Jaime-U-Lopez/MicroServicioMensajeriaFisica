package com.mensajeria.ServicioMensajeria.Repository;


import com.mensajeria.ServicioMensajeria.Model.Customer;

import java.util.List;

public interface CustomerDAO {


    public Customer create(Customer customer);

    public boolean delete(Integer cedula);

    public List<Customer> getCustomersAll();

    public Customer getCustomer(Integer cedula);

    public boolean UpdateCustomer(Customer customer);



}
