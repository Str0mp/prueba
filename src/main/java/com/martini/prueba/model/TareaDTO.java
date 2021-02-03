package com.martini.prueba.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TareaDTO {

	@JsonProperty("idTarea")
	private long idTarea;

	@JsonProperty("nombre")
	private String nombre;

	@JsonProperty("estado")
	private String estado;

	@JsonProperty("descripcion")
	private String descripcion;

	@JsonProperty("fechaCreacion")
	private Date fechaCreacion;

	@JsonProperty("fechaUltimaActualizacion")
	private Date fechaUltimaActualizacion;

	@JsonProperty("usuario")
	private UserDTO usuario;

	public TareaDTO() {
		super();
	}

	public TareaDTO(long idTarea, String nombre, String estado, String descripcion, Date fechaCreacion,
			Date fechaUltimaActualizacion, UserDTO usuario) {
		super();
		this.idTarea = idTarea;
		this.nombre = nombre;
		this.estado = estado;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
		this.usuario = usuario;
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

	public Date getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public UserDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UserDTO usuario) {
		this.usuario = usuario;
	}

}
