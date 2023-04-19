package com.mensajeria.ServicioMensajeria.Repository;

import com.mensajeria.ServicioMensajeria.Model.SendPackage;
import com.mensajeria.ServicioMensajeria.Model.StateSendPackageEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SendPackageRepository extends JpaRepository<SendPackage,Integer > {


    @Query("SELECT s FROM SendPackage s WHERE s.estadoEnvio =?1")
    public List<SendPackage> findSendPackageByState(StateSendPackageEnum estado);

    @Modifying
    @Query(value= "delete  from  paciente  where dni=:dni", nativeQuery = true)
    void eliminar(@Param("dni")Integer dni);

}
