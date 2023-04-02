package com.mensajeria.ServicioMensajeria.Repository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SendPackageImple implements SendPackageDao {

    @Autowired
    private SendPackageRepository sendPackageRepository;

    public SendPackageImple(){}


    @Override
    public SendPackageDao create(SendPackageDao sendPackageDao) {
        return null;
    }

    @Override
    public SendPackageDao update(SendPackageDao sendPackageDao) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public List<SendPackageDao> getSendPackagesAll() {
        return null;
    }

    @Override
    public SendPackageDao getSendPackage(Integer id) {
        return null;
    }
}
