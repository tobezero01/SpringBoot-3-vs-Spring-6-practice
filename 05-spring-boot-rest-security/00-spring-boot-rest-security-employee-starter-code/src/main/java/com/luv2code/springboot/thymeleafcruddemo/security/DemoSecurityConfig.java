package com.luv2code.springboot.thymeleafcruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // custom table -- new members anf roles

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to restrict a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id , pw , active from members where user_id=?"
        );

        //define query to restrict the authentication/roles by username

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id , role from roles where user_id=?"
        );

        return jdbcUserDetailsManager;
    }


    // add sp for jdbc

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws  Exception {
        httpSecurity.authorizeHttpRequests(
                config ->
                        config.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // use HTTP Basic config authentication
        httpSecurity.httpBasic((Customizer.withDefaults()));

        // disable CSRF
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }


    //    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails duc = User.builder()
//                .username("duc")
//                .password("{noop}ducnhu1234")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails kien = User.builder()
//                .username("kien")
//                .password("{noop}ducnhu1234")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails minh = User.builder()
//                .username("minh")
//                .password("{noop}ducnhu1234")
//                .roles("EMPLOYEE", "MANAGER" , "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(duc,kien,minh);
//    }

}
