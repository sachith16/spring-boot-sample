package com.senani.demo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
        return http.build();
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("abc").password("{noop}123").roles("admin_role");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/courses")
                .hasRole("admin_role")
                .antMatchers("/api/v1/course")
                .hasAnyRole("admin_role")
                .and()
                .formLogin();*/
        http.authorizeRequests().antMatchers("/api/v1/**").permitAll();
        //http.authorizeRequests().anyRequest().permitAll();
    }
}
