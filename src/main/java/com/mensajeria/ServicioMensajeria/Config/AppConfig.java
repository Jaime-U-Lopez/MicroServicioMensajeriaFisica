package com.mensajeria.ServicioMensajeria.Config;

import com.mensajeria.ServicioMensajeria.Util.CustomerMapper;
import com.mensajeria.ServicioMensajeria.Util.MapperObject;
import com.mensajeria.ServicioMensajeria.Util.MapperObjectImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MapperObject mapperObject(CustomerMapper customerMapper) {

        MapperObjectImpl mapperObject = new MapperObjectImpl();
        return mapperObject;


    }
}
