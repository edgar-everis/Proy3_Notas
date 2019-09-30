package com.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Notas;
import com.main.repository.NotasRepository;
import com.main.service.NotasService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class NotasServiceImplements implements NotasService  {

	@Autowired
	private NotasRepository repo;
	
	@Override
	public Mono<Notas> createNotas(Notas nota) {
		// TODO Auto-generated method stub
		return repo.save(nota);
	}

	@Override
	public Mono<Notas> modifyNotas(String id, Notas nota) {
		// TODO Auto-generated method stub
		nota.setId(id);
		return repo.save(nota);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		// TODO Auto-generated method stub
		return repo.deleteById(id);
	}

	@Override
	public Mono<Notas> findbyId(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Flux<Notas> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
