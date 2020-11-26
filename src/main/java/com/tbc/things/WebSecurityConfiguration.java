package com.tbc.things;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST,"/insertUserCredentials").permitAll()
                .antMatchers(HttpMethod.GET, "/getData").permitAll()
                .antMatchers(HttpMethod.POST,"/create").permitAll()
                .antMatchers(HttpMethod.GET,"/getEncrypted").permitAll()
                .antMatchers(HttpMethod.GET,"/getLogin").permitAll()
                .anyRequest().authenticated();
    }
}





