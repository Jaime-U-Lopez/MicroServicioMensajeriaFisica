package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Model.MyUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyUserDetailService implements UserDetailsService {

    private Map<String, String> users = new HashMap<>(); // Simulación de la lista de usuarios

    public MyUserDetailService() {
        users.put("user1", "123"); // Contraseña: "password1"
        users.put("user2", "123"); // Contraseña: "password2"
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!users.containsKey(username)) {
            throw new UsernameNotFoundException("User not found");
        }

        String password = users.get(username);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(username, password, authorities);
    }



}
