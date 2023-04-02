package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Model.*;
import com.mensajeria.ServicioMensajeria.Model.SendPackage;

import java.util.List;

public interface MessagingService {

    void RegisterSendPackage(SendPackage sendPackage);
    void updateSendPackageStatus(SendPackage sendPackage, StateSendPackageEnum status);
    SendPackage getSendPackageById(Long shipmentId);
    List<SendPackage> getSendPackageBySender(Customer sender);
    List<SendPackage> getSendPackageByRecipient(Customer recipient);
    void notifyRecipient(SendPackage SendPackage);
}
