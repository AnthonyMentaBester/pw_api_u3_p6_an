package com.edu.uce.pw.api.service;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.to.EstudianteTO;
import com.edu.uce.pw.api.service.to.MateriaTO;

public interface IMateriaService {
	
	public Materia buscar(Integer id);
	 
	public void actualizar(Materia materia);
 
	public void borrar(Integer id);
 
	public void guardar(Materia materia);
	
	List<Materia> buscarMateria(String materia);
	
	List<MateriaTO> buscarPorEstudiante(Integer id);
	
	//public MateriaTO buscarPorId(Integer id);

}
