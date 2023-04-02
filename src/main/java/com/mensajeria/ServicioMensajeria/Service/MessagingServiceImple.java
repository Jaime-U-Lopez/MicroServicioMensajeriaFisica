package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Model.SendPackage;
import com.mensajeria.ServicioMensajeria.Model.StateSendPackageEnum;

import java.util.List;

public class MessagingServiceImple implements MessagingService {



    @Override
    public void RegisterSendPackage(SendPackage sendPackage) {

    }

    @Override
    public void updateSendPackageStatus(SendPackage sendPackage, StateSendPackageEnum status) {

    }

    @Override
    public SendPackage getSendPackageById(Long shipmentId) {
        return null;
    }

    @Override
    public List<SendPackage> getSendPackageBySender(Customer sender) {
        return null;
    }

    @Override
    public List<SendPackage> getSendPackageByRecipient(Customer recipient) {
        return null;
    }

    @Override
    public void notifyRecipient(SendPackage SendPackage) {

    }
}
