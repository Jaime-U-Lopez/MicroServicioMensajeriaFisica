package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTO;
import com.mensajeria.ServicioMensajeria.Model.*;
import com.mensajeria.ServicioMensajeria.Model.SendPackage;

import java.util.List;
import java.util.Optional;

public interface MessagingService {

    void RegisterSendPackage(SendPackageDTO sendPackageDTO);
    void updateSendPackageStatus(SendPackage sendPackage, StateSendPackageEnum status);
    SendPackage getSendPackageById(Integer id);
    List<SendPackage> getSendPackageBySender(Customer sender);
    List<SendPackage> getSendPackageByRecipient(Customer recipient);
    void notifyRecipient(SendPackage SendPackage);

    Boolean delete(Integer id);


    public List<SendPackage> getSendPackageAll();

}
