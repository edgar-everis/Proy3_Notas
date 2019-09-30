package com.main.serviceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.main.model.Notas;
import com.main.repository.NotasRepository;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;



@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class NotasServiceImplTest {

	    @Mock
	    private NotasRepository repo;
	    
	    @InjectMocks
	    private NotasServiceImplements service;
	
	@Test
	public void testCreateNotas() {
		
		 Notas nota = new Notas();
	        nota.setId("1");
	        nota.setCurso("algoritmo");
	        nota.setAlumno("Andres");
	        nota.setProfesor("Daniel");
	        nota.setNota1(15);
	        nota.setNota2(16);
	        nota.setNota3(17);
	        
	     
	        when(repo.save(nota)).thenReturn(Mono.just(nota));
	        Mono<Notas> actual = service.createNotas(nota);
	        assertResults(actual, nota);	
	}

	@Test
	public void testModifyNotas() {
	}

	@Test
	public void testDeleteById() {
		
        Notas nota = new Notas();
        nota.setId("1");
        nota.setCurso("Algoritmo");
        nota.setAlumno("Juan");
        nota.setProfesor("Pedro");
        nota.setNota1(20);
        nota.setNota2(15);
        nota.setNota3(16);
        when(repo.delete(nota)).thenReturn(Mono.empty());
	}

	@Test
	public void testFindbyId() {
		
        Notas notas = new Notas();
       notas.setId("1");
       notas.setCurso("Algoritmo");
       notas.setAlumno("Andres");
       notas.setProfesor("Felix");
       notas.setNota1(16);
       notas.setNota2(17);
       notas.setNota3(18);
      
        when(repo.findById("1")).thenReturn(Mono.just(notas));
        Mono<Notas> actual = service.findbyId("1");
        assertResults(actual,notas);
        System.out.println(actual);
        System.out.println(notas.getAlumno());
	}

	@Test
	public void testGetAll() {
		    Notas nota = new Notas();
	        nota.setId("1");
	        nota.setCurso("algoritmo");
	        nota.setAlumno("Andres");
	        nota.setProfesor("Daniel");
	        nota.setNota1(15);
	        nota.setNota2(16);
	        nota.setNota3(17);
	        
	     
	        when(repo.findAll()).thenReturn(Flux.just(nota));
	        Flux<Notas> actual = service.getAll();
	        assertResults(actual, nota);	
	}

	  private void assertResults(Publisher<Notas> publisher, Notas... expectedProducts) {
	        StepVerifier
	            .create(publisher)
	            .expectNext(expectedProducts)
	            .verifyComplete();

	}
}
