package com.martini.prueba.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tarea")
public class DAOTarea {

	@Id
	@Column(name = "id_tarea")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTarea;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "estado")
	private String estado;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "fecha_creacion")
	Date fechaCreacion;

	@Column(name = "fecha_ultima_actualizacion")
	Date fechaUltimaActualizacion;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	DAOUser idUser;

	public DAOTarea(long idTarea, String nombre, String estado, String descripcion, Date fechaCreacion,
			Date fechaUltimaCreacion, DAOUser idUser) {
		super();
		this.idTarea = idTarea;
		this.nombre = nombre;
		this.estado = estado;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaUltimaActualizacion = fechaUltimaCreacion;
		this.idUser = idUser;
	}

	public DAOTarea() {
		super();
	}

	public long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(long idTarea) {
		this.idTarea = idTarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaUltimafechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	public void setFechaUltimafechaUltimaActualizacion(Date fechaUltimafechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimafechaUltimaActualizacion;
	}

	public DAOUser getIdUser() {
		return idUser;
	}

	public void setIdUser(DAOUser idUser) {
		this.idUser = idUser;
	}

}
