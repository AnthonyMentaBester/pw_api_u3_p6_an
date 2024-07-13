package com.edu.uce.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IEstudianteRepository;
import com.edu.uce.pw.api.repository.IMateriaRepository;
import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.to.MateriaTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MateriaServiceImpl implements IMateriaService {
	
	@Autowired
	private IMateriaRepository materiaRespository;
	
	@Override
	public Materia buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.materiaRespository.seleccionar(id);
	}
 
	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRespository.actualizar(materia);
	}
 
	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.materiaRespository.eliminar(id);
	}
 
	@Override
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRespository.actualizar(materia);
	}

	@Override
	public List<Materia> buscarMateria(String materia) {
		// TODO Auto-generated method stub
		return this.materiaRespository.seleccionarMateria(materia);
	}

	@Override
	public List<MateriaTO> buscarPorEstudiante(Integer id) {
		// TODO Auto-generated method stub
		List<Materia> lista = this.materiaRespository.seleccionarPorEstudiante(id);
		List<MateriaTO> listafinal = new ArrayList<>();
		for (Materia mat : lista) {
			listafinal.add(this.convertir(mat));
			
		}
		return listafinal;
	}

	public MateriaTO convertir(Materia mat) {
		// TODO Auto-generated method stub
		MateriaTO mateTO = new MateriaTO();
		mateTO.setCreditos(mat.getCreditos());
		mateTO.setHoras(mat.getHoras());
		mateTO.setId(mat.getId());
		mateTO.setNivel(mat.getNivel());
		mateTO.setNombre(mat.getNombre());
		
		return mateTO;
	}

	//@Override
	//public Materia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		//return this.materiaRespository.seleccionar(id);
	//}
	
	
 

}
