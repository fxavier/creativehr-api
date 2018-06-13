package com.xavier.creativehrapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xavier.creativehrapi.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);
	
}
