package com.example.tipos;

import java.time.LocalDate;

import com.example.Principal;

public class Profesor extends Persona {
	private double salario = 1000.00;

	public Profesor(int id, String nombre, String apellidos, LocalDate fechaNacimiento, LocalDate fechaBaja, double salario) {
		super(id, nombre, apellidos, fechaNacimiento, fechaBaja, 67);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public void jubilate() {
		Principal.out.println("Yuhuuu");
		salario = 0;
		setActivo(false);
		//super.jubilate();
	}

	@Override
	public String toString() {
		return "Profesor [id" + getId() + ", nombre=" + getNombre() + ", apellidos=" + getApellidos()
				+ ", salario=" + salario + "]";
	}
	
	@Override
	protected Profesor clone() {
		// TODO Auto-generated method stub
		try {
			return (Profesor)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
