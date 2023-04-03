package com.mensajeria.ServicioMensajeria.Repository;


import com.mensajeria.ServicioMensajeria.Model.Customer;

import java.util.List;

public interface CustomerDAO {


    public boolean create(Customer customer);

    public boolean delete(Integer id);

    public List<Customer> getCustomersAll();

    public Customer getCustomer(Integer id);

    public boolean UpdateCustomer(Customer customer);



}
