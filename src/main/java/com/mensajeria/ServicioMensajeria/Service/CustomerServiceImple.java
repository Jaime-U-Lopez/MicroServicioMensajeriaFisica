package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Dto.CustomerDTO;
import com.mensajeria.ServicioMensajeria.Exception.ExcepcionCustomer;
import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Repository.CustomerReposImple;
import com.mensajeria.ServicioMensajeria.Util.UpdateFieldUtil;
import com.mensajeria.ServicioMensajeria.Util.ValidarCorreo;
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
    public CustomerDTO create(CustomerDTO customerDTO)  throws RuntimeException {

        String correoElectronico= customerDTO.getCorreoElectronico();
        Integer cedula = customerDTO.getCedula();
        String name= customerDTO.getName();
        String lastName= customerDTO.getLastName();
        Long numeroCelular= customerDTO.getNumeroCelular();
        validarCliente(cedula,name,lastName,correoElectronico, numeroCelular);

        Optional<CustomerDTO> respuestaRepositoryCustomer = Optional.of(this.customerReposImple.create(customerDTO));
        if (!respuestaRepositoryCustomer.isPresent()) {
            throw new ExcepcionCustomer("Customer could not be created");
        }
        return this.customerReposImple.create(customerDTO);
    }



    private void validarCliente(Integer cedula, String nombre,  String apellido, String correoElectronico,Long numeroCelular) throws RuntimeException {
        if (apellido == null || nombre == null || cedula < 0  || !(cedula instanceof Integer) || numeroCelular < 0  || !(numeroCelular instanceof Long)) {
            throw new ExcepcionCustomer("Creacion del  cliente con cc : " + cedula + "no cumple los parametros, de apellido, nombre y cedula en integer");
        }
        Boolean confirmarEstrucEmail= ValidarCorreo.esCorreoValido(correoElectronico);
        if(!confirmarEstrucEmail){
            throw new ExcepcionCustomer("The email entered does not meet the parameters ");
        }
        if (customerReposImple.getCustomer(cedula) != null) {
            throw new ExcepcionCustomer("El cliente con cedula: " + cedula + "  ya existe en la base de datos");
        }
    }

    @Override
    public List<Customer> getCustomerAll()  throws RuntimeException{
        Optional<List<Customer>> customerList = Optional.ofNullable(this.customerReposImple.getCustomersAll());
        if (!customerList.isPresent()) {
            throw new ExcepcionCustomer("There are no customers in the database");
        }
        return this.customerReposImple.getCustomersAll();
    }

    @Override
    public Customer getCustomer(Integer id)  throws RuntimeException {
        Optional<Customer> customer = Optional.ofNullable(this.customerReposImple.getCustomer(id));
        if (!customer.isPresent()) {
            throw new ExcepcionCustomer("The customer " + id + " not existed in database");
        }
        return customer.get();
    }

    @Override
    public Boolean delete(Integer cedula) throws RuntimeException {

        this.getCustomer(cedula);
        Optional<Boolean> customer = Optional.ofNullable(this.customerReposImple.delete(cedula));
        if (!customer.isPresent()) {
            throw new ExcepcionCustomer("The customer "+ cedula + " not existed in database");
        }
        return true;

    }

    @Override
    public Customer updateCustomer(Customer customer)  throws RuntimeException {
        Integer idCedula = customer.getCedula();
        String correoElectronico= customer.getCorreoElectronico();
        Boolean confirmarEstrucEmail= ValidarCorreo.esCorreoValido(correoElectronico);
        if(!confirmarEstrucEmail){
            throw new ExcepcionCustomer("The email entered does not meet the parameters ");
        }
        Optional<Customer> customerOptiona = Optional.ofNullable(this.customerReposImple.getCustomer(idCedula));
        if (!customerOptiona.isPresent()) {
            throw new ExcepcionCustomer("Unable to update customer not existed  in database");
        }

        customerOptiona.ifPresent(c -> {
            UpdateFieldUtil.updateFieldNullEmptyString(customer.getName(), c::setName);
            UpdateFieldUtil.updateFieldNullEmptyString(customer.getLastName(), c::setLastName);
            UpdateFieldUtil.updateFieldLong(customer.getNumeroCelular(), (value) -> c.setNumeroCelular(value));
            UpdateFieldUtil.updateFieldNullEmptyString(customer.getCiudad(), c::setCiudad);
            UpdateFieldUtil.updateFieldNullEmptyString(customer.getCorreoElectronico(), c::setCorreoElectronico);
            UpdateFieldUtil.updateFieldNullEmptyString(customer.getDireccionResidencia(), c::setDireccionResidencia);

            this.customerReposImple.UpdateCustomer(c);
        });

        return customerOptiona.get();
    }
}
