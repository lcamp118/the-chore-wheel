package com.bonniewhy.thechorewheel.configuration;

import com.bonniewhy.thechorewheel.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDao userDao;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/", "signup", "signin", "/css/*", "/js/*", "images/*").permitAll()
                .antMatchers("/room/add").hasAuthority("ADMIN")
                .antMatchers("/**").hasAuthority("USER")

        .and().formLogin()
                .loginPage("/signin")
                .defaultSuccessUrl("/")

        .and().logout()
                .logoutUrl("/signout")
                .logoutSuccessUrl("/");

    }

}
