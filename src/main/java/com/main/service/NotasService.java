package com.main.service;



import com.main.model.Notas;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NotasService {

	Mono<Notas> createNotas(Notas nota);

	Mono<Notas> modifyNotas(String id, Notas nota);

	Mono<Void> deleteById(String id);

	Mono<Notas> findbyId(String id);

	Flux<Notas> getAll();
}
