package com.mensajeria.ServicioMensajeria.Repository;

import com.mensajeria.ServicioMensajeria.Model.AdressSendComp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdressSendCompImple  implements AdressSendCompDAO{

    private  AdressSendCompRepository adressSendCompRepository;

    @Autowired
    public AdressSendCompImple(AdressSendCompRepository adressSendCompRepository) {
        this.adressSendCompRepository = adressSendCompRepository;
    }

    public AdressSendCompImple(){};

    @Override
    public AdressSendComp create( AdressSendComp adressSendComp) {
        return  this.adressSendCompRepository.save(adressSendComp) ;
    }
}
