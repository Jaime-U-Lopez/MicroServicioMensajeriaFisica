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
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class BasicAuthConfiguration  extends WebSecurityConfigurerAdapter {

 //   @Value("${username}")
   // private String username;

    //@Value("${password}")
    //private String password;


    private MyUserDetailService UserDetailService;


    @Autowired
    public BasicAuthConfiguration(MyUserDetailService userDetailService){
        this.UserDetailService=userDetailService;

    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService());
        auth.inMemoryAuthentication()
                .withUser("user1").password("123").roles("APPRENTICE")
                .and()
                .withUser("user2").password("123").roles("SENSEI");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }



    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/customers").hasAnyRole("SENSEI", "ROLE2", "ROLE3")
                .antMatchers("/employees").hasRole("APPRENTICE")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

    /*

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http,
                                    AuthenticationManager authManager) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
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
                .roles()
                .build()
        );
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



    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }


    public void configure(WebSecurity web) {
        // Configuración de recursos estáticos, etc.
        web.ignoring().antMatchers("/swagger-ui.html");
    }


     */

}
