package com.main.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Notas;

@Repository
public interface NotasRepository extends ReactiveMongoRepository<Notas, String>{

}
