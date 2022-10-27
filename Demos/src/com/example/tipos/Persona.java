package com.example.tipos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public abstract class Persona implements Cloneable {
	public static final int MAYORIA_DE_EDAD = 18;
	public final int edadJubilacion;
	
	private int id;
	private String nombre = "(anonimo)";
	private String apellidos;
	private LocalDate fechaNacimiento;
	private int edad = -1;
	private boolean activo = true;
	private LocalDate fechaBaja;
	
//	public Persona() {
//		this.edadJubilacion = 67;
//	}
	
	public Persona(int id, String nombre, String apellidos) {
		this(id, nombre, apellidos, null, null, 67);
	}

	public Persona(int id, String nombre, String apellidos, LocalDate fechaNacimiento, LocalDate fechaBaja,
			int edadJubilacion) {
		this.id = id;
		setNombre(nombre);
		this.apellidos = apellidos;
		setFechaNacimiento(fechaNacimiento);
		this.fechaBaja = fechaBaja;
		this.edadJubilacion = edadJubilacion;
	}
	
	public String getNombre() {
		return nombre.toUpperCase();
	}
	
	public void setNombre(String valor) {
		if(nombre.equals(valor)) return;
		if(valor == null || valor.trim().length() < 2)
			throw new IllegalArgumentException("Nombre no valido");
		nombre = valor;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	private int calculaEdad() {
		return (int) fechaNacimiento.until(LocalDate.now(), ChronoUnit.YEARS);
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento == null) {
			this.fechaNacimiento = null;
			this.edad = -1;
		}
		if(fechaNacimiento.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("Tiene que haber nacido ya");
		this.fechaNacimiento = fechaNacimiento;
		edad = calculaEdad();
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		setFechaNacimiento(LocalDate.parse(fechaNacimiento));
	}

	public LocalDate getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public int getEdad() {
		return edad;
	}

	public boolean isActivo() {
		return fechaBaja != null;
	}
	
	protected void setActivo(boolean valor) {
		activo = valor;
	}
	public void jubilate() {
		fechaBaja = LocalDate.now();
		activo = false;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		return id == other.id;
	}
	
	
}
