package com.spring.start.seguridad;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.start.usuario.Usuario;
import com.spring.start.usuario.UsuarioDAO;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioDAO.findById(username);
		if (usuario.isPresent()) return (UserDetails) usuario.get();
		throw new UsernameNotFoundException(username);
	}
}
