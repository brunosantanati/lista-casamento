package com.capgemini.casamento.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class PainelDeControleSecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.inMemoryAuthentication()
				.withUser("bruno")
				.password(new BCryptPasswordEncoder().encode("123456"))
				.roles("ADMIN")
			.and()
				.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.antMatcher("/painel-de-controle/**")
				.authorizeRequests().anyRequest().hasRole("ADMIN")
			.and()
				.httpBasic();
	}

}
