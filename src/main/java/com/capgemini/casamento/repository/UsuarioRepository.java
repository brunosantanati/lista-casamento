package com.capgemini.casamento.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.capgemini.casamento.model.Usuario;

public interface UsuarioRepository extends Repository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);
	
	Optional<Usuario> findById(Long usuarioId);
	
	Usuario save(Usuario usuario);

}
