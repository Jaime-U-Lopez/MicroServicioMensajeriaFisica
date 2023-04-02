package com.mensajeria.ServicioMensajeria.Repository;


import com.mensajeria.ServicioMensajeria.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerImpleRepos implements CustomerDAO {


    @Autowired
    public CustomerImpleRepos() {
    }


    @Override
    public boolean createElement(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteElement(Integer id) {
        return false;
    }

    @Override
    public List<Object> getElementAll() {
        return null;
    }

    @Override
    public Object getElement(Integer id) {
        return null;
    }

    @Override
    public boolean UpdateElement(Customer customer) {
        return false;
    }
}
