package com.mensajeria.ServicioMensajeria.Repository;




import com.mensajeria.ServicioMensajeria.Model.Packages;

import javax.persistence.Entity;
import java.util.List;


public interface PackageDAO {


    Packages create(Packages packages);

    List<Packages> getPackagesAll();

    Packages getPackages( Integer id);

    Boolean deletePackages( Integer Id);

    Packages UpdatePackages( Packages packages );


}
