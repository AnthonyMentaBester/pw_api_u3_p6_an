package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IMateriaService;

@RestController
@RequestMapping(path = "/materias")
public class MateriaController {

	@Autowired
	private IMateriaService materiaService;
	
	//http://localhost:8080/API/v1.0/Matricula/materias/guardar
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Materia mat) {
		/*{
  			"mat_id": 1,
  			"mat_nombre": "nombre",
  			"mat_horas": 0,
  			"mat_creditos": "creditos",
  			"mat_nivel": "nivel"
			}*/
		
		this.materiaService.guardar(mat);
		
	}
	
	//http://localhost:8080/API/v1.0/Matricula/materias/actualizar
	@PutMapping(path = "/actualizar")
	public void actualizar(@RequestBody Materia mat) {
		
		this.materiaService.actualizar(mat);
		
	}
	
	//http://localhost:8080/API/v1.0/Matricula/materias/actualizarParcial
	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial(@RequestBody Materia mat) {
		Materia mat2 = this.materiaService.buscar(mat.getId());
		
		if(mat.getNombre()!=null) {
			mat2.setNombre(mat.getNombre());
		}
		if(mat.getHoras()!=null) {
			mat2.setHoras(mat.getHoras());
		}
		if(mat.getCreditos()!=null) {
			mat2.setCreditos(mat.getCreditos());
		}
		if(mat.getNivel()!=null) {
			mat2.setNivel(mat.getNivel());		
		}
		this.materiaService.actualizar(mat2);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/materias/borrar
	//http://localhost:8080/API/v1.0/Matricula/materias/borrar/3
	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		System.out.println("Borrar");
		this.materiaService.borrar(id);
		
	}
	
	//http://localhost:8080/API/v1.0/Matricula/materias/buscar
	//http://localhost:8080/API/v1.0/Matricula/materias/buscar/5
	@GetMapping(path = "/buscar/{id}")
	public Materia buscar(@PathVariable Integer id) {
		return this.materiaService.buscar(id);
		
	}
	
	//http://localhost:8080/API/v1.0/Matricula/materias/buscarMateria/nombre
	@GetMapping(path = "/buscarMateria/nombre")
	public List<Materia> buscarMateria(@RequestParam String nombre){
		List<Materia> lista = this.materiaService.buscarMateria(nombre);
		return lista;
		
	}
}
