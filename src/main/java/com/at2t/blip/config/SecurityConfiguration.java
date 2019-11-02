package com.at2t.blip.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);



        //For custom schema
        /*    .usersByUsernameQuery("select Email as username, PassCode as password, 1 as enabled"
                    + "from LoginCredential"
                    + "where Email = ?" )
            .authoritiesByUsernameQuery(" select lc.Email as username, pt.PersonTypeName as authority"
                    + "from LoginCredential lc"
                    + "join Person p on lc.PersonId = p.PersonId"
                    + "join PersonType pt on p.PersonId = pr.PersonId"
                    + "where Email = ?");*/

        //For Default H2 Schema
                /*.withDefaultSchema()
                .withUser(
                        User.withUsername("admin")
                        .password("pass")
                        .roles("ADMIN")
                )
                .withUser(
                        User.withUsername("user")
                                .password("pass")
                                .roles("USER")
                );*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN","USER")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
