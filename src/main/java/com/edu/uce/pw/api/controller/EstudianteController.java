package com.edu.uce.pw.api.controller;

import java.time.LocalDateTime;
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

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.IEstudianteService;

@RestController
//pasa a ser un recurso
@RequestMapping(path = "/estudiantes")
public class EstudianteController {
	
	@Autowired
	private IEstudianteService estudianteService;
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante est) {
		//Estudiante est = new Estudiante();
		//est.setNombre("anthony");
		//est.setApellido("narvaez");
		//est.setFechaNacimiento(LocalDateTime.of(1999, 8, 11, 5, 50));
		
		this.estudianteService.guardar(est);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	@PutMapping(path = "/actualizar")
	public void actualizar(@RequestBody Estudiante est) {
		//Estudiante est = this.estudianteService.buscar(2);
		//est.setNombre("daniel");
		//est.setApellido("teran");
		//est.setFechaNacimiento(LocalDateTime.now());
		this.estudianteService.actualizar(est);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial(@RequestBody Estudiante est) {
		Estudiante est2 = this.estudianteService.buscar(est.getId());
		
		if(est.getNombre()!=null) {
			est2.setNombre(est.getNombre());
		}
		if(est.getApellido()!=null) {
			est2.setApellido(est.getApellido());
		}
		if(est.getFechaNacimiento()!=null) {
			est2.setFechaNacimiento(est.getFechaNacimiento());
			
		}
		//est.setNombre("carlos");
		this.estudianteService.actualizar(est2);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/3
	//aqui la debo anotar cuidado con el elemento se debe buscar
	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		System.out.println("Borrar");
		this.estudianteService.borrar(id);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/5
	@GetMapping(path = "/buscar/{id}")
	public Estudiante buscar(@PathVariable Integer id) {
		return this.estudianteService.buscar(id);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarGenero/genero
	@GetMapping(path = "/buscarGenero/genero")
	public List<Estudiante> buscarGenero(@RequestParam String genero){
		List<Estudiante> lista = this.estudianteService.buscarGenero(genero);
		return lista;
		
	}

}
