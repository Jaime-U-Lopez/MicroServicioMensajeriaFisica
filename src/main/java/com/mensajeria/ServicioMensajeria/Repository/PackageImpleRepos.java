package com.mensajeria.ServicioMensajeria.Repository;


import com.mensajeria.ServicioMensajeria.Model.Packages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PackageImpleRepos  implements PackageDAO {



    private PackageRepository packageRepository;

    @Autowired
    public PackageImpleRepos(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public PackageImpleRepos (){};

    @Override
    public Packages create(Packages packages) {
        return null;
    }

    @Override
    public List<Packages> getPackagesAll() {
        return null;
    }

    @Override
    public Packages getPackages(Integer id) {
        return null;
    }

    @Override
    public Boolean deletePackages(Integer Id) {
        return null;
    }

    @Override
    public Packages UpdateEmployee(Packages packages) {
        return null;
    }


}
