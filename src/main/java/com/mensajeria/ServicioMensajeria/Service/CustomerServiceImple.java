package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Exception.ExcepcionCustomer;
import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Repository.CustomerReposImple;
import com.mensajeria.ServicioMensajeria.Util.UpdateFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImple implements CustomerService {


    private CustomerReposImple customerReposImple;

    @Autowired
    public CustomerServiceImple(CustomerReposImple customerReposImple) {
        this.customerReposImple = customerReposImple;
    }

    public CustomerServiceImple() {
    }

    @Override
    public Customer create(Customer customer) {

        return this.customerReposImple.create(customer);
    }

    @Override
    public List<Customer> getCustomerAll() {

        Optional <List<Customer>> customerList= Optional.ofNullable(this.customerReposImple.getCustomersAll());
        if (customerList.isPresent()){
            throw new ExcepcionCustomer("No existen clientes en la base de datos ");
        }

        return this.customerReposImple.getCustomersAll();
    }

    @Override
    public Customer getCustomer(Integer id) {

        Optional<Customer> customer = Optional.ofNullable(this.customerReposImple.getCustomer(id));

        if (!customer.isPresent()) {
            throw new RuntimeException("The customer not existed in database");
        }

        return customer.get();
    }

    @Override
    public Boolean delete(Integer cedula) {

        Optional<Boolean> customer = Optional.ofNullable(this.customerReposImple.delete(cedula));

        if (!customer.isPresent()) {
            throw new RuntimeException("The customer not existed in database");
        }

        return true;

    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Integer idCedula = customer.getCedula();


        Optional<Customer> customerOptiona = Optional.ofNullable(this.customerReposImple.getCustomer(idCedula));

        if (!customerOptiona.isPresent()) {
            throw new ExcepcionCustomer("No es posible actualizar al cliente no figuran en la base de datos");
        }


        customerOptiona.ifPresent(c -> {

            UpdateFieldUtil.updateFieldNullEmptyString(customer.getName(), c::setName);
            UpdateFieldUtil.updateFieldNullEmptyString(customer.getLastName(), c::setLastName);
            UpdateFieldUtil.updateFieldLong(customer.getCelular(), (value) -> c.setCelular(value));
            UpdateFieldUtil.updateFieldNullEmptyString(customer.getCiudad(), c::setCiudad);
            UpdateFieldUtil.updateFieldNullEmptyString(customer.getCorreoElectronico(), c::setCorreoElectronico);
            UpdateFieldUtil.updateFieldNullEmptyString(customer.getDireccionResidencia(), c::setDireccionResidencia);

            this.customerReposImple.UpdateCustomer(c);
        });


        return customerOptiona.get();
    }
}
