package com.martini.prueba.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.martini.prueba.model.DAOTarea;
import com.martini.prueba.model.TareaDTO;

public interface TareaService {

	DAOTarea agregarTarea(TareaDTO tarea,Authentication authentication);
	
	List<TareaDTO> obtenerTareas(Authentication authentication);
	
	TareaDTO updateTarea(Authentication authentication, TareaDTO tarea);
	
	TareaDTO deleteTarea(Authentication authentication,TareaDTO tarea);

}
