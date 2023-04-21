package com.mensajeria.ServicioMensajeria.Security;


import com.mensajeria.ServicioMensajeria.Service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import  org.springframework.http.HttpMethod;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class BasicAuthConfiguration   {


    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/employees").permitAll()
                .antMatchers("/customers").hasRole("READ")
                .antMatchers(HttpMethod.GET).hasAuthority("READ")
                .antMatchers(HttpMethod.POST).hasAuthority("WRITE")
                .antMatchers(HttpMethod.PUT).hasAuthority("WRITE")
                .antMatchers(HttpMethod.DELETE).hasAuthority("WRITE")
                .antMatchers(HttpMethod.POST, "/employees").hasAuthority("WRITE_EMPLOYEE")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
               .build();
    }

    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername(username)
                .password(passwordEncoder().encode(password))
                .roles("All")
                .authorities("READ","WRITE")
                .build());
    manager.createUser( User.withUsername("user")
                        .password(passwordEncoder().encode("user123"))
                        .authorities("READ")
                        .build());
      manager.createUser( User.withUsername("admin")
                      .password(passwordEncoder().encode("admin123"))
                      .authorities("READ","WRITE")
                      .build());

        return manager;
    }



    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder())
                .and().build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
