package com.mensajeria.ServicioMensajeria.Repository;


import com.mensajeria.ServicioMensajeria.Model.Packages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PackageReposImple implements PackageDAO {



    private PackageRepository packageRepository;

    @Autowired
    public PackageReposImple(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public PackageReposImple(){};

    @Override
    public Packages createPackage(Packages packages) {
        return this.packageRepository.save(packages);
    }

    @Override
    public List<Packages> getPackagesAll() {
       List<Packages> packagesList=  Optional.ofNullable(this.packageRepository.findAll())
                .map(packages -> packages.stream().collect(Collectors.toList()))
                .orElse(Collections.emptyList());
        return packagesList;

    }

    @Override
    public Packages getPackages(Integer id) {
        Optional<Packages>  packages= this.packageRepository.findById(id);
        return packages.get();
    }

    @Override
    public Boolean deletePackages(Integer id) {
        this.packageRepository.deleteById(id);
        return true;
    }

    @Override
    public Packages UpdatePackages(Packages packages) {
        return this.packageRepository.saveAndFlush(packages);
    }


}
