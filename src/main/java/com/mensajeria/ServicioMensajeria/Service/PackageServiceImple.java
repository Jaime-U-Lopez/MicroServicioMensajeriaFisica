package com.mensajeria.ServicioMensajeria.Service;


import com.mensajeria.ServicioMensajeria.Exception.ExcepcionPackage;
import com.mensajeria.ServicioMensajeria.Model.Employee;
import com.mensajeria.ServicioMensajeria.Model.Packages;
import com.mensajeria.ServicioMensajeria.Model.SendPackage;
import com.mensajeria.ServicioMensajeria.Repository.PackageReposImple;
import com.mensajeria.ServicioMensajeria.Util.UpdateFieldUtil;
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
    public List<Packages> getPackagesAll() {

        Optional<List<Packages>> packagesList= Optional.ofNullable(this.packageReposImple.getPackagesAll());

        if (!packagesList.isPresent()){
            throw  new RuntimeException("The SendPackage not existed in database");
        }
        return packagesList.get();
    }

    @Override
    public Packages getPackages( Integer numeroGuia) {

        Optional<Packages> packages= Optional.ofNullable(this.packageReposImple.getPackages(numeroGuia));

        if (!packages.isPresent()){
            throw  new RuntimeException("The SendPackage not existed in database");
        }

        return packages.get();

    }

    @Override
    public Boolean delete(Integer numeroGuia) {

        Optional<Boolean> packages = Optional.ofNullable(this.packageReposImple.deletePackages(numeroGuia));

        if (!packages.isPresent()) {
            throw new RuntimeException("The Packages  not existed in database");
        }

        return true;


    }

    @Override
    public Packages updatePackages(Packages packages) {
        Integer id= packages.getId();
        Optional<Packages> packagesOptional=Optional.ofNullable(this.packageReposImple.getPackages(id));

        if(!packagesOptional.isPresent()){
            throw new ExcepcionPackage("No se pudo realizar el update del package, no existe en la base de datos");
        }


        packagesOptional.ifPresent(c->{

            UpdateFieldUtil.updateFieldInteger(packages.getPesoPaquete(), c::setPesoPaquete );

            this.packageReposImple.UpdatePackages(c);
        });

        return packagesOptional.get();
    }
}
