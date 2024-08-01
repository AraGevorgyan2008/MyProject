package com.ara.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers( "/").permitAll()
                                .requestMatchers( "/login").permitAll()
                                .requestMatchers( "/signing").permitAll()
                                .requestMatchers( "/user").permitAll()
                                .requestMatchers( "/admin").permitAll()
                                .requestMatchers( "/verif").permitAll()
                                .requestMatchers( "/verify_Admin").permitAll()
                                .requestMatchers("/addPhone").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/frfc")
                                .permitAll()
                )
                .logout(logout ->
                        logout.permitAll()
                );

        return http.build();
    }
}
