package com.edu.uce.pw.api.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.edu.uce.pw.api.repository.IEstudianteRepository;
import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;
 
 
 
@Service
public class EstudianteServiceImpl implements IEstudianteService{
 
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(id);
	}
 
	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}
 
	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}
 
	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public List<Estudiante> buscarGenero(String genero) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarGenero(genero);
	}
	
	public EstudianteTO convertir(Estudiante est) {
		EstudianteTO estTo = new EstudianteTO();
		estTo.setId(est.getId());
		estTo.setApellido(est.getApellido());
		estTo.setGenero(est.getGenero());
		estTo.setNombre(est.getNombre());
		estTo.setFechaNacimiento(est.getFechaNacimiento());
		return estTo;
		
	}

	@Override
	public EstudianteTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		Estudiante est = this.estudianteRepository.seleccionar(id);
		return this.convertir(est);
	}
 
}