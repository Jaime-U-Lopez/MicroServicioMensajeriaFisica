package com.mensajeria.ServicioMensajeria.Repository;

import com.mensajeria.ServicioMensajeria.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer,Integer> {


}
