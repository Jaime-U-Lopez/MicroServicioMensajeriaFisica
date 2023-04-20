package com.mensajeria.ServicioMensajeria.Service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {

    public UserDetails loadUserByUsername(String username) ;

}
