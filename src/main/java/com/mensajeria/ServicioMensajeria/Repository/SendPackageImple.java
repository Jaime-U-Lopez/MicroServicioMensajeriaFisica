package com.mensajeria.ServicioMensajeria.Repository;

import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SendPackageImple implements SendPackageDao {

    @Autowired
    private SendPackageRepository sendPackageRepository;

    public SendPackageImple(){}


    @Override
    public SendPackageDTO create(SendPackageDTO sendPackageDTO) {
        return null;
    }

    @Override
    public SendPackageDTO update(SendPackageDTO sendPackageDTO) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public List<SendPackageDTO> getSendPackagesAll() {
        return null;
    }

    @Override
    public SendPackageDTO getSendPackage(Integer id) {
        return null;
    }
}
