package it.academy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityDocumentConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.jdbcAuthentication().dataSource(dataSource);

//        auth.inMemoryAuthentication()
//                .withUser(userBuilder
//                        .username("yury")
//                        .password("yury")
//                        .roles("MANAGER"))
//                .withUser(userBuilder
//                        .username("user")
//                        .password("user")
//                        .roles("VIEWER"))
//                .withUser(userBuilder
//                        .username("admin")
//                        .password("admin")
//                        .roles("ADMIN"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("MANAGER", "VIEWER", "ADMIN")
                .antMatchers("/document/all/").hasAnyRole("MANAGER", "VIEWER", "ADMIN")
                .antMatchers("/document/add/").hasAnyRole("MANAGER", "ADMIN")
                .and().formLogin().permitAll();
    }
}
