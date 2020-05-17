package com.capgemini.casamento.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capgemini.casamento.model.Usuario;
import com.capgemini.casamento.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> possibleUser = usuarioRepository.findByEmail(username);
		
		return possibleUser.orElseThrow(() -> 
				new UsernameNotFoundException("Não foi possível " + 
				"encontrar usuário com email: " + username));
	}
	
	public UserDetails loadUserById(Long userId) {
		
		Optional<Usuario> possibleUser = usuarioRepository.findById(userId);
		
		return possibleUser.orElseThrow(
				() -> new UsernameNotFoundException("Não foi possível encontrar o "
						+ "usuário com id: " + userId));
		
	}

}
