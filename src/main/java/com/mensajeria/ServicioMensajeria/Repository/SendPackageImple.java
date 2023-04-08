package com.mensajeria.ServicioMensajeria.Repository;

import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTO;
import com.mensajeria.ServicioMensajeria.Exception.ExceptionSendPackage;
import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Model.Packages;
import com.mensajeria.ServicioMensajeria.Model.SendPackage;
import com.mensajeria.ServicioMensajeria.Model.StateSendPackageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SendPackageImple implements SendPackageDao {


    private SendPackageRepository sendPackageRepository;
    @Autowired
    public SendPackageImple(SendPackageRepository sendPackageRepository) {
        this.sendPackageRepository = sendPackageRepository;
    }

    public SendPackageImple(){}


    @Override
    public SendPackage create(SendPackage sendPackage) {
        return  this.sendPackageRepository.save(sendPackage);
    }

    @Override
    public SendPackage update(SendPackage sendPackage) {
        return this.sendPackageRepository.saveAndFlush(sendPackage);
    }

    @Override
    public Boolean delete(Integer id) {
        this.sendPackageRepository.deleteById(id);
        return true;
    }

    @Override
    public List<SendPackage> getSendPackagesAll() {

        List<SendPackage> sendPackageList=  Optional.ofNullable(this.sendPackageRepository.findAll())
                .map(packages -> packages.stream().collect(Collectors.toList()))
                .orElse(Collections.emptyList());

        return  sendPackageList;
    }

    @Override
    public SendPackage getSendPackage(Integer id) {

        try {
            Optional<SendPackage> sendPackage= this.sendPackageRepository.findById(id);
            return sendPackage.get();
        }catch (Exception e){
            throw new ExceptionSendPackage("El id del package no existe ");
        }

    }

    public  List<SendPackage>  findSendPackageByState(StateSendPackageEnum stateSendPackageEnum){
        return  this.sendPackageRepository.findSendPackageByState( stateSendPackageEnum );
    }
}
