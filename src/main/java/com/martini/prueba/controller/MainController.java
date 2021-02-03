package com.martini.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martini.prueba.model.DAOTarea;
import com.martini.prueba.model.TareaDTO;
import com.martini.prueba.model.UserDTO;
import com.martini.prueba.service.TareaService;
import com.martini.prueba.service.UserService;

@RestController
public class MainController {
	
	@Autowired
	TareaService tareaService;
	
	@Autowired 
	UserService userService;
	
	@RequestMapping({ "/hello" })
	public String firstPage(Authentication authentication) {
		return "Hello World " + authentication.getName();
	}

	
	@RequestMapping({ "/agregarTarea" })
	public DAOTarea agregarTarea(Authentication authentication, @RequestBody TareaDTO tarea) {
		return tareaService.agregarTarea(tarea,authentication);
	}
	
	@GetMapping({"/obtenerTareas"})
	public List<TareaDTO> obtenerTareas(Authentication authentication) {
		return tareaService.obtenerTareas(authentication);
	}
	
	@GetMapping({"/obtenerInfoUsuario"})
	public UserDTO obtenerInfoUsuario(Authentication authentication) {
		return userService.obtenerUsuario(authentication);
	}
	
	@GetMapping({"/actualizarTarea"})
	public TareaDTO actualizarTarea(Authentication authentication,@RequestBody TareaDTO tarea) {
		return tareaService.updateTarea(authentication, tarea);
	}
	
	@GetMapping({"/eliminarTarea"})
	public TareaDTO eliminarTarea(Authentication authentication,@RequestBody TareaDTO tarea) {
		return tareaService.deleteTarea(authentication, tarea);
	}
}
