package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTO;
import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Model.Employee;
import com.mensajeria.ServicioMensajeria.Model.SendPackage;
import com.mensajeria.ServicioMensajeria.Model.StateSendPackageEnum;
import com.mensajeria.ServicioMensajeria.Repository.SendPackageImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MessagingServiceImple implements MessagingService {


    private SendPackageImple sendPackageImple;

    @Autowired
    public MessagingServiceImple(SendPackageImple sendPackageImple) {
        this.sendPackageImple = sendPackageImple;
    }

    public MessagingServiceImple() {
    }

    @Override
    public void RegisterSendPackage(SendPackageDTO sendPackageDTO) {






        this.sendPackageImple.create(sendPackageDTO);
    }

    @Override
    public void updateSendPackageStatus(SendPackage sendPackage, StateSendPackageEnum status) {

    }

    @Override
    public SendPackage getSendPackageById(Integer id) {

        Optional<SendPackage> sendPackage= Optional.ofNullable(this.sendPackageImple.getSendPackage(id));

        if (!sendPackage.isPresent()){
            throw  new RuntimeException("The SendPackage not existed in database");
        }

        return sendPackage.get();


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

    @Override
    public Boolean delete(Integer id) {
        Optional<Boolean> customer = Optional.ofNullable(this.sendPackageImple.delete(id));

        if (!customer.isPresent()) {
            throw new RuntimeException("The Employee  not existed in database");
        }

        return true;
    }

    @Override
    public List<SendPackage> getSendPackageAll() {
        return this.sendPackageImple.getSendPackagesAll();
    }
}
