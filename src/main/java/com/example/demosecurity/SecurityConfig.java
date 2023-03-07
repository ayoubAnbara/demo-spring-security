package com.example.demosecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Ayoub ANBARA
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  //  @Order(2)
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config -> {
            config.antMatchers("/private/**").authenticated();
            config.anyRequest().permitAll();
        });
        http.formLogin(Customizer.withDefaults());
        http.userDetailsService(userDetailsService());
        http.addFilterBefore(new RobotFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

  /*  @Order(1)
    @Bean
    SecurityFilterChain securityFilterChainApi(HttpSecurity http) throws Exception {
        http.antMatcher("/api/**");
        http.authorizeHttpRequests(config -> {
            config.antMatchers("/api/**").authenticated();
            config.anyRequest().permitAll();
        });
        http.formLogin(Customizer.withDefaults());
        http.userDetailsService(userDetailsService());

        return http.build();
    }*/

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails userDetails = User.builder()
                .username("admin")
                .password("{noop}admin")
                .authorities("ROLE_ADMIN")
                .build();
        return new InMemoryUserDetailsManager(List.of(userDetails));
    }

   /* @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }*/


}
