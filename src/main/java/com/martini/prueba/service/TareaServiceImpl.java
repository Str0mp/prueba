package com.martini.prueba.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.martini.prueba.dao.TareaDao;
import com.martini.prueba.dao.UserDao;
import com.martini.prueba.model.DAOTarea;
import com.martini.prueba.model.DAOUser;
import com.martini.prueba.model.TareaDTO;
import com.martini.prueba.model.UserDTO;

@Service
public class TareaServiceImpl implements TareaService {

	@Autowired
	TareaDao tareaDao;

	@Autowired
	UserDao userDao;

	@Autowired
	EntityManager em;

	@SuppressWarnings("null")
	@Override
	public DAOTarea agregarTarea(TareaDTO tarea, Authentication authentication) {
		DAOTarea daoTarea = new DAOTarea();
		DAOUser daoUser = new DAOUser();
		if (null != tarea && tarea.getUsuario().getUsername().equalsIgnoreCase(authentication.getName())) {
			daoTarea.setNombre(tarea.getNombre());
			daoTarea.setEstado(tarea.getEstado());
			daoTarea.setDescripcion(tarea.getDescripcion());
			daoTarea.setFechaCreacion(new Date(System.currentTimeMillis()));
			daoTarea.setFechaUltimafechaUltimaActualizacion(new Date(System.currentTimeMillis()));
			daoUser = userDao.findByUsername(tarea.getUsuario().getUsername());
			daoTarea.setIdUser(daoUser);
			daoTarea = tareaDao.save(daoTarea);
		}
		return daoTarea;
	}

	@Override
	public List<TareaDTO> obtenerTareas(Authentication authentication) {
		DAOUser user = new DAOUser();
		TareaDTO tarea = null;
		UserDTO userDTO = null;
		List<TareaDTO> listaTarea = new ArrayList<TareaDTO>();
		user.setUsername(authentication.getName());
		List<DAOTarea> lista = (List<DAOTarea>) tareaDao.findAll();
		for (DAOTarea daoTarea : lista) {
			if (daoTarea.getIdUser().getUsername().equalsIgnoreCase(authentication.getName())) {
				tarea = new TareaDTO();
				userDTO = new UserDTO();
				tarea.setIdTarea(daoTarea.getIdTarea());
				tarea.setDescripcion(daoTarea.getDescripcion());
				tarea.setNombre(daoTarea.getNombre());
				tarea.setEstado(daoTarea.getEstado());
				tarea.setFechaCreacion(daoTarea.getFechaCreacion());
				tarea.setFechaUltimaActualizacion(daoTarea.getFechaUltimafechaUltimaActualizacion());
				userDTO.setNombre(daoTarea.getIdUser().getNombre());
//				userDTO.setPassword(daoTarea.getIdUser().getPassword());  En teoría no se debería entregar la password
				userDTO.setUsername(daoTarea.getIdUser().getUsername());
				tarea.setUsuario(userDTO);
				listaTarea.add(tarea);
			}

		}
		return listaTarea;
	}

	@Override
	public TareaDTO updateTarea(Authentication authentication, TareaDTO tarea) {
		DAOTarea daoTarea = null;
		TareaDTO tareaDTO = null;
		UserDTO userDTO = null;
		if (null != tarea) {
			daoTarea = tareaDao.findById(tarea.getIdTarea()).orElse(null);
			if (authentication.getName().equalsIgnoreCase(daoTarea.getIdUser().getUsername())) {
				daoTarea.setEstado(tarea.getEstado());
				daoTarea.setFechaUltimafechaUltimaActualizacion(new Date(System.currentTimeMillis()));
				daoTarea = tareaDao.save(daoTarea);

				tareaDTO = new TareaDTO();
				tareaDTO.setDescripcion(daoTarea.getDescripcion());
				tareaDTO.setEstado(daoTarea.getEstado());
				tareaDTO.setFechaCreacion(daoTarea.getFechaCreacion());
				tareaDTO.setFechaUltimaActualizacion(daoTarea.getFechaUltimafechaUltimaActualizacion());
				tareaDTO.setIdTarea(daoTarea.getIdTarea());
				tareaDTO.setNombre(daoTarea.getNombre());

				userDTO = new UserDTO();
				userDTO.setNombre(daoTarea.getNombre());
//				userDTO.setPassword(daoTarea.getIdUser().getPassword()); ??????????
				userDTO.setUsername(daoTarea.getIdUser().getUsername());
				tareaDTO.setUsuario(userDTO);
			}

		}
		return tareaDTO;
	}

	@Override
	@Transactional
	public TareaDTO deleteTarea(Authentication authentication, TareaDTO tarea) {
		DAOTarea daoTarea = null;
		TareaDTO tareaDTO = null;
		if (null != tarea) {
			daoTarea = tareaDao.findById(tarea.getIdTarea()).orElse(null);
			if (null != daoTarea && authentication.getName().equalsIgnoreCase(daoTarea.getIdUser().getUsername())) {
				String naviteQuery = "DELETE FROM tarea WHERE ID_TAREA= ?";
				@SuppressWarnings("unused")
				int x = em.createNativeQuery(naviteQuery).setParameter(1, daoTarea.getIdTarea()).executeUpdate();
				tareaDTO = new TareaDTO();
				tareaDTO.setDescripcion(daoTarea.getDescripcion());
				tareaDTO.setEstado(daoTarea.getEstado());
				tareaDTO.setFechaCreacion(daoTarea.getFechaCreacion());
				tareaDTO.setFechaUltimaActualizacion(daoTarea.getFechaUltimafechaUltimaActualizacion());
				tareaDTO.setIdTarea(daoTarea.getIdTarea());
				tareaDTO.setNombre(daoTarea.getNombre());
				UserDTO userDTO = new UserDTO();
				userDTO.setNombre(daoTarea.getIdUser().getNombre());
//				userDTO.setPassword(daoTarea.getIdUser().getPassword());
				userDTO.setUsername(daoTarea.getIdUser().getUsername());
				tareaDTO.setUsuario(userDTO);

			}
		}

		return tareaDTO;
	}

}
