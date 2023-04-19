package com.mensajeria.ServicioMensajeria.Util;

import com.mensajeria.ServicioMensajeria.Dto.CustomerDTO;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTO;
import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Model.SendPackage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SendPackageMapper {



        SendPackage dtoToEntity(SendPackageDTO sendPackageDTO);
        SendPackageDTO  entityToDto(SendPackage sendPackage);

        List<SendPackageDTO> entityListToDtoList(List<SendPackage> entityList);

}
