package com.edu.uce.pw.api.service.to;

import java.io.Serializable;

import jakarta.persistence.Column;

public class MateriaTO implements Serializable{
	
	private static final long serialVersionUID = 235562941894409723L;
	
	private Integer id;
	 
	private String nombre;
 
	private Integer horas;
 
	private String creditos;
	
	private String nivel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//set y get

}
