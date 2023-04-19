package com.mensajeria.ServicioMensajeria.Util;

import com.mensajeria.ServicioMensajeria.Dto.CustomerDTO;
import com.mensajeria.ServicioMensajeria.Model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperObject {


   // MapperObject INSTANCE = Mappers.getMapper(MapperObject.class);

  //  @Mapping(source = "id", target = "id", ignore = false)
    Customer dtoToEntity(CustomerDTO dto);

    List<Customer> dtoListToEntityList(List<CustomerDTO> dtoList);

//    @Mapping(source = "age", target = "age", defaultValue = "0")
    CustomerDTO entityToDto(Customer entity);

    List<CustomerDTO> entityListToDtoList(List<Customer> entityList);


/*

    public interface UserMapper {

        UserDto toDto (User user);

        User toDomain(UserDto userDto);
    }


 */
}
