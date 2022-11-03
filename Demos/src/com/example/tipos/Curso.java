package com.example.tipos;

public class Curso implements Grafico {
	private Profesor profesor;

	public Curso(Profesor profesor, double salario) {
		super();
		this.profesor = profesor.clone();
		this.profesor.setSalario(salario);
	}

	public Profesor getProfesor() {
		return profesor.clone();
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public void pintate() {
		System.out.println("Soy un curso");
	}
	
	
}
