package com.martini.prueba.service;

import org.springframework.security.core.Authentication;

import com.martini.prueba.model.UserDTO;

public interface UserService {
	
	UserDTO obtenerUsuario(Authentication authentication);
	

}
