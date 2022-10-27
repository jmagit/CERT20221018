package com.example.tipos;

public class Curso {
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
	
	
}
