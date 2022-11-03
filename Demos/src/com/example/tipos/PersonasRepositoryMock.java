package com.example.tipos;

import java.util.List;
import java.util.Optional;

public class PersonasRepositoryMock implements PersonasRepository {

	@Override
	public List<Persona> getAll() {
		System.out.println("Esta es la de pruebas");
		return null;
	}

	@Override
	public Optional<Persona> getOne(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Persona add(Persona item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona modify(Persona item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Persona item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

}
