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
	//NIVEL 1: http://localhost:8080/API/v1.0/Matricula/estudiantes
	@PostMapping
	public void guardar(@RequestBody Estudiante est) {
		//Estudiante est = new Estudiante();
		//est.setNombre("anthony");
		//est.setApellido("narvaez");
		//est.setFechaNacimiento(LocalDateTime.of(1999, 8, 11, 5, 50));
		
		this.estudianteService.guardar(est);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	//NIVEL 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/6
	@PutMapping(path = "/{id}")
	public void actualizar(@RequestBody Estudiante est,@PathVariable Integer id) {
		est.setId(id);
		//Estudiante est = this.estudianteService.buscar(2);
		//est.setNombre("daniel");
		//est.setApellido("teran");
		//est.setFechaNacimiento(LocalDateTime.now());
		this.estudianteService.actualizar(est);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
	//NIVEL 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/6
	@PatchMapping(path = "/{id}")
	public void actualizarParcial(@RequestBody Estudiante est,@PathVariable Integer id) {
		est.setId(id);
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
	
	//NIVEL 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/3
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		System.out.println("Borrar");
		this.estudianteService.borrar(id);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/5/nuevo/prueba
	//NIVEL 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/5
	@GetMapping(path = "/{id}")
	public Estudiante buscar(@PathVariable Integer id) {

		return this.estudianteService.buscar(id);
		
	}
	//los request param para el valor uso ? siempre al final
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarGenero?genero=M&edad=24
	@GetMapping(path = "/buscarGenero")
	public List<Estudiante> buscarGenero(@RequestParam String genero,@RequestParam Integer edad){
		System.out.println("Edad: " + edad);
		List<Estudiante> lista = this.estudianteService.buscarGenero(genero);
		return lista;
		
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarMixto/5?prueba=HolaMundo
	@GetMapping(path = "/buscarMixto/{id}")
	public Estudiante buscarMixto(@PathVariable Integer id,@RequestParam String prueba) {
		System.out.println("Dato:" + id);
		System.out.println("Dato:" + prueba);
		return this.estudianteService.buscar(id);
			
	}
	
	

}
