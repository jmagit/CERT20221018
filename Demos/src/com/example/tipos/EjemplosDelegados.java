package com.example.tipos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class EjemplosDelegados {

	void pincipal() {
		List<String> lista = new ArrayList<>();
		// ...
		class Compara implements Comparator<String> {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		}
		ordena(lista, new Compara());
		ordena(lista, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -o1.compareTo(o2);
			}
		});
		ordena(lista, (o1, o2) -> o1.toLowerCase().compareTo(o2.toLowerCase()));
		filtra(lista, item -> item.equals(item.toUpperCase()));
	}

	List<String> filtra(List<String> lst, Predicate<String> predicate) {
		predicate.test(null);
		return null;
	}
	void ordena(List<String> lst, Comparator<String> comparator) {
		String s1 = "", s2 = "";
		// ...
			if (comparator.compare(s1, s2) == 0) {
				// ...
			} else if (comparator.compare(s1, s2) < 0) { // s1 < s2
				// ...
			} else { // s1 > s2
				// ...
			}
		// ...
	}
	/*
	void ordena(List<String> lst, int tipo) {
		int s1 = 0, s2 = 0;
		// ...
		switch (tipo) {
		case 1:
			if (s1 == s2) {
				// ...
			} else if (s1 < s2) {
				// ...
			} else { // s1 > s2
				// ...
			}
			break;
		case 2:
			if (s1 == s2) {
				// ...
			} else if (s1 > s2) {
				// ...
			} else { // s1 < s2
				// ...
			}
			break;
		// case
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipo);
		}
		// ...
	}
	  void ordenaAsc(List<String> lst) { int s1 = 0, s2 = 0; //... if(s1 == s2) {
	  //... } else if(s1 < s2) { // ... } else { // s1 > s2 // ... } // ... }
	  
	  void ordenaDes(List<String> lst) { int s1 = 0, s2 = 0; //... if(s1 == s2) {
	  //... } else if(s1 > s2) { // ... } else { // s1 < s2 // ... } // ... }
	 */
}
