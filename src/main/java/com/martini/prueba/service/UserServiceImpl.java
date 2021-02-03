package com.martini.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.martini.prueba.dao.UserDao;
import com.martini.prueba.model.DAOUser;
import com.martini.prueba.model.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public UserDTO obtenerUsuario(Authentication authentication) {
		UserDTO user = null;
		DAOUser daoUser = null;
		if(!authentication.getName().equalsIgnoreCase("")) {
			user = new UserDTO();
			daoUser = userDao.findByUsername(authentication.getName());
			user.setNombre(daoUser.getNombre());
			user.setPassword(daoUser.getPassword());
			user.setUsername(daoUser.getUsername());
		}
		return user;
	}

}
