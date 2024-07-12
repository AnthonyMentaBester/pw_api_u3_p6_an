package com.edu.uce.pw.api.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IMateriaService;

@RestController
@RequestMapping(path = "/materias")
public class MateriaController {

	@Autowired
	private IMateriaService materiaService;

	// http://localhost:8080/API/v1.0/Matricula/materias/guardar
	// NIVEL 1: http://localhost:8080/API/v1.0/Matricula/materias
	@PostMapping
	public ResponseEntity<Materia> guardar(@RequestBody Materia mat) {
		/*
		 * { "mat_id": 1, "mat_nombre": "nombre", "mat_horas": 0, "mat_creditos":
		 * "creditos", "mat_nivel": "nivel" }
		 */

		this.materiaService.guardar(mat);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_201", "Corresponde a la agregacion recurso.");
		return new ResponseEntity<>(mat,cabeceras,201);

	}

	// http://localhost:8080/API/v1.0/Matricula/materias/actualizar
	// NIVEL 1: http://localhost:8080/API/v1.0/Matricula/materias/1
	@PutMapping(path = "/{id}")
	public ResponseEntity<Materia> actualizar(@RequestBody Materia mat, @PathVariable Integer id) {
		mat.setId(id);
		this.materiaService.actualizar(mat);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_238", "Corresponde a la actualizacion completa del recurso.");
		return new ResponseEntity<>(mat,cabeceras,238);

	}

	// http://localhost:8080/API/v1.0/Matricula/materias/actualizarParcial
	// NIVEL 1: http://localhost:8080/API/v1.0/Matricula/materias/1
	@PatchMapping(path = "/{id}")
	public ResponseEntity<Materia> actualizarParcial(@RequestBody Materia mat, @PathVariable Integer id) {
		mat.setId(id);
		Materia mat2 = this.materiaService.buscar(mat.getId());

		if (mat.getNombre() != null) {
			mat2.setNombre(mat.getNombre());
		}
		if (mat.getHoras() != null) {
			mat2.setHoras(mat.getHoras());
		}
		if (mat.getCreditos() != null) {
			mat2.setCreditos(mat.getCreditos());
		}
		if (mat.getNivel() != null) {
			mat2.setNivel(mat.getNivel());
		}
		this.materiaService.actualizar(mat2);
		
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_239", "Corresponde a la actualizacion parcial del recurso.");
		return new ResponseEntity<>(mat2,cabeceras,239);

	}

	// http://localhost:8080/API/v1.0/Matricula/materias/borrar
	// http://localhost:8080/API/v1.0/Matricula/materias/borrar/3
	// NIVEL 1: http://localhost:8080/API/v1.0/Matricula/materias/1
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
		System.out.println("Borrar");
		this.materiaService.borrar(id);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_240", "Corresponde a la eliminacion del recurso.");
		return new ResponseEntity<>("Borrado",cabeceras,240);

	}

	// http://localhost:8080/API/v1.0/Matricula/materias/buscar
	// http://localhost:8080/API/v1.0/Matricula/materias/buscar/5
	// NIVEL 1: http://localhost:8080/API/v1.0/Matricula/materias/1
	@GetMapping(path = "/{id}")
	public ResponseEntity<Materia> buscarPorId(@PathVariable Integer id) {
		//return this.materiaService.buscar(id);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta del recurso.");
		return new ResponseEntity<>(this.materiaService.buscar(id),cabeceras,236);

	}

	// http://localhost:8080/API/v1.0/Matricula/materias/buscarMateria/nombre
	// NIVEL 1:
	// http://localhost:8080/API/v1.0/Matricula/materias/materia?nombre=Programacion
	@GetMapping(path = "/materia")
	public ResponseEntity<List<Materia>> buscarMateria(@RequestParam String nombre) {
		List<Materia> lista = this.materiaService.buscarMateria(nombre);
		//return lista;
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta del recurso.");
		cabeceras.add("Valor ", "Materia encontrada");
		return new ResponseEntity<>(lista,cabeceras,236 );

	}

	// NIVEL 1:
	// http://localhost:8080/API/v1.0/Matricula/materias/mixto/2?prueba=MateriasActivas
	@GetMapping(path = "/mixto/{id}")
	public ResponseEntity<Materia> buscarMixto(@PathVariable Integer id, @RequestParam String prueba) {
		System.out.println("Dato:" + id);
		System.out.println("Dato:" + prueba);
		//return this.materiaService.buscar(id);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta mixta del recurso.");
		cabeceras.add("Valor ", "Materia encontrada");
		return new ResponseEntity<>(this.materiaService.buscar(id),cabeceras,236 );

	}

}
