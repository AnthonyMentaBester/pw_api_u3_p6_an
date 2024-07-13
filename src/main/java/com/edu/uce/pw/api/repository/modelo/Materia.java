package com.edu.uce.pw.api.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {
	
	@Column(name = "mat_id")
	@Id
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	@GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
	private Integer id;
 
	@Column(name = "mat_nombre")
	private String nombre;
 
	@Column(name = "mat_horas")
	private Integer horas;
 
	@Column(name = "mat_creditos")
	private String creditos;
	
	@Column(name = "mat_nivel")
	private String nivel;
	
	@ManyToOne
	@JoinColumn(name = "mate_id_estudiante")
	private Estudiante estudiante;
	
	//getters y setters

	
	public Integer getId() {
		return id;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
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
	
	
	

}
