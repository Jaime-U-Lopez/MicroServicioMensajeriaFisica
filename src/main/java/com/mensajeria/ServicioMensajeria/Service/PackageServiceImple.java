package com.mensajeria.ServicioMensajeria.Service;


import com.mensajeria.ServicioMensajeria.Model.Packages;
import com.mensajeria.ServicioMensajeria.Model.SendPackage;
import com.mensajeria.ServicioMensajeria.Repository.PackageReposImple;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageServiceImple implements PackageService {

    private PackageReposImple packageReposImple;

    public PackageServiceImple(PackageReposImple packageReposImple) {
        this.packageReposImple = packageReposImple;
    }

    public PackageServiceImple() {
    }

    @Override
    public Packages create(Packages packages) {
        return this.packageReposImple.create(packages);
    }

    @Override
    public List<Packages> getCustomerAll() {

        return this.packageReposImple.getPackagesAll();
    }

    @Override
    public Packages getCustomer( Integer id) {


        Optional<Packages> packages= Optional.ofNullable(this.packageReposImple.getPackages(id));

        if (!packages.isPresent()){
            throw  new RuntimeException("The SendPackage not existed in database");
        }

        return packages.get();

    }

    @Override
    public Boolean delete(Integer cedula) {

        Optional<Boolean> customer = Optional.ofNullable(this.packageReposImple.deletePackages(cedula));

        if (!customer.isPresent()) {
            throw new RuntimeException("The Employee  not existed in database");
        }

        return true;


    }
}
