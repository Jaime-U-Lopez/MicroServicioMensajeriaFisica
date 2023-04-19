package com.mensajeria.ServicioMensajeria.Service;


import com.mensajeria.ServicioMensajeria.Exception.ExcepcionCustomer;
import com.mensajeria.ServicioMensajeria.Exception.ExcepcionPackage;
import com.mensajeria.ServicioMensajeria.Model.Employee;
import com.mensajeria.ServicioMensajeria.Model.Packages;
import com.mensajeria.ServicioMensajeria.Model.SendPackage;
import com.mensajeria.ServicioMensajeria.Repository.PackageReposImple;
import com.mensajeria.ServicioMensajeria.Util.UpdateFieldUtil;
import com.mensajeria.ServicioMensajeria.Util.ValidarCorreo;
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
    public Packages create(Packages packages)  throws RuntimeException {

        Integer pesoPackage=  packages.getPesoPaquete();
        Integer valorPackage=   packages.getValorPaquete();
        String typePackage=  packages.getTypePackage();
        validarCliente(pesoPackage, typePackage, valorPackage );

        Optional<Packages>packagesOptional=Optional.of(this.packageReposImple.createPackage(packages));
        if (!packagesOptional.isPresent()){
            throw new ExcepcionPackage("El paquete no se pudo crear valide la información ingresa.");
        }
        return packagesOptional.get();
    }

    private void validarCliente(Integer pesoPaquete, String typePackage,  Integer valorPaquete) throws RuntimeException {
        if (typePackage == null || pesoPaquete < 0  || !(pesoPaquete instanceof Integer) || valorPaquete < 0  || !(valorPaquete instanceof Integer)) {
            throw new ExcepcionCustomer("Creacion del  Package  no se puede realizar, no cumple los parametros, de valor Package y peso Package no puede ser menor a cero , o Type Package esta null");
        }

    }



    @Override
    public List<Packages> getPackagesAll()   throws RuntimeException{

        Optional<List<Packages>> packagesList= Optional.ofNullable(this.packageReposImple.getPackagesAll());

        if (!packagesList.isPresent()){
            throw  new RuntimeException("The SendPackage not existed in database");
        }
        return packagesList.get();
    }

    @Override
    public Packages getPackages( Integer id)  throws RuntimeException {


            Optional<Packages> packages= Optional.of(this.packageReposImple.getPackages(id));
            if (!packages.isPresent()|| packages.isEmpty()){
                throw  new ExcepcionPackage("The SendPackage not existed in database");
            }
            return packages.get();

    }

    @Override
    public Boolean delete(Integer numeroGuia)  throws RuntimeException {

        this.getPackages(numeroGuia);
        Optional<Boolean> packages = Optional.ofNullable(this.packageReposImple.deletePackages(numeroGuia));
        if (!packages.isPresent()) {
            throw new ExcepcionPackage("The customer "+ numeroGuia + " not existed in database");
        }
        return true;

    }

    @Override
    public Packages updatePackages(Packages packages) {
        Integer id= packages.getId();

        Integer pesoPackage=  packages.getPesoPaquete();
        Integer valorPackage=   packages.getValorPaquete();
        String typePackage=  packages.getTypePackage();
        validarCliente(pesoPackage, typePackage, valorPackage );

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
