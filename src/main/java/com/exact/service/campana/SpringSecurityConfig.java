package com.exact.service.campana;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.session.SessionManagementFilter;

import com.exact.service.campana.auth.filter.JWTAuthorizationFilter;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.addFilterBefore(corsFilter(), JWTAuthorizationFilter.class)
		.addFilter(new JWTAuthorizationFilter(authenticationManager())).csrf().disable().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}	
	
	@Bean
    CorsFilter corsFilter() {
        CorsFilter filter = new CorsFilter();
        return filter;
    }
}