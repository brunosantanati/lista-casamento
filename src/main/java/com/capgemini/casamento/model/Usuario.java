package com.capgemini.casamento.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;

	private String senha;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> authorities = new ArrayList<>();

	/**
	 * @deprecated
	 */
	public Usuario() {	}
	
	public Usuario(String name, String email, String password) {
		this.nome = name;
		this.email = email;
		this.senha = password;
	}
	
	public Long getId() {
		return this.id;
	}

	public String getName() {
		return nome;
	}

	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.senha;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario user = (Usuario) o;
		return Objects.equals(email, user.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
