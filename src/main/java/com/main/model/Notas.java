package com.main.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document(collection = "Notas")
public class Notas {
	
	@Id
	private String id;
	
	private String curso;
	
	private String alumno;
	
	private String profesor;
	
	private int nota1;
	
	private int nota2;
	
	private int nota3;
	
	
	
	
	
	public double  promedio(int nota1, int nota2,int nota3)
	{
		return nota1+nota2+nota3/3;
		
	}

}
