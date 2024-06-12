package com.example.application.security;

import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jose.jws.JwsAlgorithms;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * <code>VaadinWebSecurity</code> used in favor of the now deprecated
 * <code>VaadinWebSecurityConfigurerAdapter</code>
 * 
 * @see com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity { // punto 1

    @Value("${app.secret}")
    private String appSecret;

    @Override
    protected void configure(HttpSecurity http) throws Exception { // punto 2
        super.configure(http);
        
        // Disable creating and using sessions in Spring Security
        http.sessionManagement(management -> management
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

       
        // Register your login view to the view access checker mechanism
        setLoginView(http, "/login");
        // Enable stateless authentication
        setStatelessAuthentication(http,
                new SecretKeySpec(Base64.getDecoder().decode(
                        appSecret),
                        JwsAlgorithms.HS256),
                "localhost");
    }
    
    @Bean
    public UserDetailsManager userDetailsService() { // punto 3
        // Configure users and roles in memory
        return new InMemoryUserDetailsManager(
                // the {noop} prefix tells Spring that the password is not encoded
                //User.withUsername("user").password("{noop}user").roles("USER").build(),
                //User.withUsername("admin").password("{noop}admin").roles("ADMIN", "USER").build()
                User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build()
        );
    }
}
