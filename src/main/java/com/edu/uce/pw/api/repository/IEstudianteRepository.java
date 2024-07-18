package com.edu.uce.pw.api.repository;
 
import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
 
public interface IEstudianteRepository {
 
	//CRUD
	public Estudiante seleccionar(Integer id);
	
	public void actualizar(Estudiante estudiante);
	
	public void eliminar(Integer id);
	
	public void insertar(Estudiante estudiante);
	
	List<Estudiante> seleccionarGenero(String genero);
	List<Estudiante> seleccionarTodos();
}