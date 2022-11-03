package com.example.tipos;

import java.time.LocalDate;
import java.util.Arrays;

public class Alumno extends Persona {
	private int[] notas = new int[10];
	
	public Alumno(int id, String nombre, String apellidos, LocalDate fechaNacimiento, LocalDate fechaBaja,
			int edadJubilacion) {
		super(id, nombre, apellidos, fechaNacimiento, fechaBaja, edadJubilacion);
		Arrays.fill(notas, -1);
	}
	
	public void addNota(int asignatura, int nota) {
		if(asignatura < 0 || asignatura > notas.length)
			throw new IllegalArgumentException("Asignatura fuera de rango");
		if(nota < 0 || nota > 10)
			throw new IllegalArgumentException("Notas fuera de rango");
		notas[asignatura] = nota;
	}
	
	public int[] getNotas() {
		return notas.clone();
	}
	public int getNota(int asignatura) {
		if(asignatura < 0 || asignatura > notas.length)
			throw new IllegalArgumentException("Asignatura fuera de rango");
		return notas[asignatura];
	}

	@Override
	public void pintate() {
		System.out.println("Soy un alumno");
	}
}
