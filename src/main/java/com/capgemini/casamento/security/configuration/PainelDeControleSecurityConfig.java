package com.capgemini.casamento.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.capgemini.casamento.security.service.UsuarioService;

@Configuration
@EnableWebSecurity
public class PainelDeControleSecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**.html", "/webjars/**", "/styles/**", "/img/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
			    .antMatchers("/lista-de-casamento/**").permitAll()
			    .antMatchers("/painel-de-controle/**").hasRole("ADMIN")
			    .anyRequest().authenticated()
		    .and()
	        	.formLogin();
	}

}
