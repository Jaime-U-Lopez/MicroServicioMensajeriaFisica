package com.mensajeria.ServicioMensajeria.Service;


import com.mensajeria.ServicioMensajeria.Exception.ExcepcionPackage;
import com.mensajeria.ServicioMensajeria.Model.Employee;
import com.mensajeria.ServicioMensajeria.Model.Packages;
import com.mensajeria.ServicioMensajeria.Model.SendPackage;
import com.mensajeria.ServicioMensajeria.Repository.PackageReposImple;
import com.mensajeria.ServicioMensajeria.Util.UpdateFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageServiceImple implements PackageService {

    private PackageReposImple packageReposImple;

    @Autowired
    public PackageServiceImple(PackageReposImple packageReposImple) {
        this.packageReposImple = packageReposImple;
    }

    public PackageServiceImple() {
    }

    @Override
    public Packages create(Packages packages) {

        Optional<Packages>packagesOptional=Optional.of(this.packageReposImple.createPackage(packages));

        if (!packagesOptional.isPresent()){
            throw new ExcepcionPackage("El paquete no se pudo crear valide la información ingresa.");
        }

        return packagesOptional.get();
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
    public Packages getPackages( Integer id) {


        try {
            Optional<Packages> packages= Optional.of(this.packageReposImple.getPackages(id));
            if (!packages.isPresent()|| packages.isEmpty()){
                throw  new ExcepcionPackage("The SendPackage not existed in database");
            }
            return packages.get();
        }catch (ExcepcionPackage e){
            throw  new ExcepcionPackage("The  Id no existe en la base de datos ");
        }catch (EmptyResultDataAccessException e) {
            throw new ExcepcionPackage("The ID does not exist in the database");
        }



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
            UpdateFieldUtil.updateFieldInteger(packages.getValorPaquete(), c::setValorPaquete );
            UpdateFieldUtil.updateFieldNullEmptyString(packages.getTypePackage(), c::setTypePackage);

            this.packageReposImple.UpdatePackages(c);
        });

        return packagesOptional.get();
    }
}
