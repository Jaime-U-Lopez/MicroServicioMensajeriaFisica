package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTO;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTOGet;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTOUpdate;
import com.mensajeria.ServicioMensajeria.Model.*;
import com.mensajeria.ServicioMensajeria.Model.SendPackage;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

public interface MessagingService {

    ResponseEntity<String> RegisterSendPackage(SendPackageDTO sendPackageDTO);
    ResponseEntity<String> updateSendPackageStatus(SendPackageDTOUpdate sendPackageDTOUpdate );
    SendPackageDTOGet getSendPackageById(Integer id);
    List<SendPackage> getSendPackageByState(StateSendPackageEnum stateSendPackageEnum, Integer cedulaEmpleado);
    List<SendPackage> getSendPackageByRecipient(Customer recipient);
    void notifyRecipient(SendPackage SendPackage);

    Boolean delete(Integer id);


    public List<SendPackage> getSendPackageAll();

}
