package com.mensajeria.ServicioMensajeria.Util;

import com.mensajeria.ServicioMensajeria.Dto.CustomerDTO;
import com.mensajeria.ServicioMensajeria.Model.Customer;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface CustomerMapper {



        Customer dtoToEntity(CustomerDTO customerDTO);
        CustomerDTO entityToDto(Customer customer);


}
