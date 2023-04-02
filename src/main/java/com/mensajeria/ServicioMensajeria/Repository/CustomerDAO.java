package com.mensajeria.ServicioMensajeria.Repository;


import com.mensajeria.ServicioMensajeria.Model.Customer;

import java.util.List;

public interface CustomerDAO {


    public boolean createElement(Customer customer);

    public boolean deleteElement(Integer id);

    public List<Object> getElementAll();

    public Object getElement(Integer id);

    public boolean UpdateElement(Customer customer);



}
