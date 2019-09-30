package com.main.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Notas;
import com.main.serviceImpl.NotasServiceImplements;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/API/Notas")
public class NotasController {

	@Autowired
	private NotasServiceImplements service;

	@GetMapping
	public Flux<Notas> Getall() {
		return service.getAll();}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Notas> createStudent(@RequestBody Notas nota) {
		return service.createNotas(nota);
	}

	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Notas> updateStudent(@PathVariable String id, @RequestBody Notas nota) {
		return service.modifyNotas(id, nota);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteStudents(@PathVariable String id) {
		return service.deleteById(id);
	}

}
