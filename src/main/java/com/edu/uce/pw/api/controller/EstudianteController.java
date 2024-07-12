package com.edu.uce.pw.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.IEstudianteService;

@RestController
//pasa a ser un recurso
@RequestMapping(path = "/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	// NIVEL 1: http://localhost:8080/API/v1.0/Matricula/estudiantes
	@PostMapping(produces = "application/json", consumes = "application/xml")
	public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante est) {
		// Estudiante est = new Estudiante();
		// est.setNombre("anthony");
		// est.setApellido("narvaez");
		// est.setFechaNacimiento(LocalDateTime.of(1999, 8, 11, 5, 50));

		this.estudianteService.guardar(est);
		//return ResponseEntity.status(201).body(est);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_201", "Corresponde a la agregacion del recurso");
		return new ResponseEntity<>(est,cabeceras,201 );

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	// NIVEL 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/6
	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
		// Estudiante est = this.estudianteService.buscar(2);
		// est.setNombre("daniel");
		// est.setApellido("teran");
		// est.setFechaNacimiento(LocalDateTime.now());
		this.estudianteService.actualizar(est);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_238", "Corresponde a la actualizacion del recurso.");
		return new ResponseEntity<>(est,cabeceras,238);
		//return ResponseEntity.status(238).body(estudiante);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
	// NIVEL 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/6
	@PatchMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> actualizarParcial(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
		Estudiante est2 = this.estudianteService.buscar(est.getId());

		if (est.getNombre() != null) {
			est2.setNombre(est.getNombre());
		}
		if (est.getApellido() != null) {
			est2.setApellido(est.getApellido());
		}
		if (est.getFechaNacimiento() != null) {
			est2.setFechaNacimiento(est.getFechaNacimiento());

		}
		// est.setNombre("carlos");
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_239", "Corresponde a la actualizacion parcial del recurso.");
		return new ResponseEntity<>(est2,cabeceras,239 );
		//return ResponseEntity.status(239).body(estudiante2);

	}
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/3
	// aqui la debo anotar cuidado con el elemento se debe buscar

	// NIVEL 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/3
	@DeleteMapping(path = "/{id}",produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
		System.out.println("Borrar");
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_240", "Corresponde a la eliminacion del recurso.");
		return new ResponseEntity<>("Borrado",cabeceras,240);		
		//return ResponseEntity.status(240).body("Borrado");

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/5/nuevo/prueba
	// NIVEL 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/5
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estudiante> buscarPorId(@PathVariable Integer id) {

		// return ResponseEntity.status(236).body(this.estudianteService.buscar(id));

		// CUANDO QUIERO MANDAR COMO CABECERA
		// estas se manejan por clave valor son registros
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta de un recurso");
		cabeceras.add("valor", "Estudiante encontrado");
		return new ResponseEntity<>(this.estudianteService.buscar(id), cabeceras, 236);

	}

	// los request param para el valor uso ? siempre al final
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarGenero?genero=M&edad=24
	// NIVEL 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/genero?genero=M
	@GetMapping(path = "/genero", consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<Estudiante>> buscarGenero(@RequestParam String genero) {
		List<Estudiante> lista = this.estudianteService.buscarGenero(genero);
		//return lista;		
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta del recurso.");
		cabeceras.add("Valor ", "Estudiante encontrado");
		return new ResponseEntity<>(lista,cabeceras,236 );

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarMixto/5?prueba=HolaMundo
	// NIVEL 1:
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/mixto/5?prueba=HolaMundo
	@GetMapping(path = "/mixto/{id}", consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> buscarMixto(@PathVariable Integer id, @RequestParam String prueba) {
		System.out.println("Dato:" + id);
		System.out.println("Dato:" + prueba);
		//return this.estudianteService.buscar(id);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta mixta del recurso.");
		cabeceras.add("Valor ", "Estudiante encontrado");
		return new ResponseEntity<>(this.estudianteService.buscar(id),cabeceras,236 );

	}

	// NIVEL 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/test/4
	@GetMapping(path = "/test/{id}")
	public ResponseEntity<Estudiante> test(@PathVariable Integer id, @RequestBody Estudiante est) {
		System.out.println(est);
		//return this.estudianteService.buscar(id);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta test del recurso.");
		cabeceras.add("Valor ", "Estudiante encontrado");
		return new ResponseEntity<>(this.estudianteService.buscar(id),cabeceras,236 );
	}
	// NIVEL 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/texto/plano
	@GetMapping(path = "/texto/plano")
	public String prueba() {
		String prueba = "TEXTO DE PRUEBA";
		return prueba;
		
	}

}
