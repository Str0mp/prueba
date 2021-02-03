package com.martini.prueba.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.martini.prueba.model.DAOTarea;

@Repository
public interface TareaDao extends CrudRepository<DAOTarea, Long> {

}
