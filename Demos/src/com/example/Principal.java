package com.example;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;

import com.example.enumeraciones.DiasDeLaSemana;
import com.example.enumeraciones.DiasLaborables;
import com.example.exceptions.DemosException;
import com.example.tipos.Alumno;
import com.example.tipos.Curso;
import com.example.tipos.EjemplosGenericos;
import com.example.tipos.Grafico;
import com.example.tipos.Persona;
import com.example.tipos.PersonasRepository;
import com.example.tipos.PersonasRepositoryImpl;
import com.example.tipos.PersonasRepositoryMock;
import com.example.tipos.Profesor;

/**
 * Clase principal con las demos del curso
 * 
 * @author Javier
 * @version 1.0.0
 * @since 17
 *
 */
public class Principal {
	public static final PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
	private int instancia = 0;
	/**
	 * Punto de arranque de la aplicacion
	 * 
	 * @param args -d para lo que sea
	 */
	public static void main(String[] args) {
		var app = new Principal();
//		app.instancia = 1;
//		out.println(app.suma(2, 2));
		app.consultas(new PersonasRepositoryMock());
//		try {
//			app.errores();
//			
//		} catch (Exception e) {
//			System.err.println("En el main");
//			e.printStackTrace();
//			System.out.println("Termine con errores ....");
//			System.exit(0);
//		}
//		app.genericos(new PersonasRepositoryMock());
//		out.println(app.avg(2, 2));
//		out.println(app.avg(1, 2, 3, 4 , 5));
//		out.println(app.avg(1));
//		out.println(app.avg());
		System.out.println("Termine ....");
	}
	
	public void consultas(PersonasRepository dao) {
		var lst = dao.getAll();
		lst.forEach(System.out::println);
	}

	public void errores() throws Exception {
		Persona p = new Profesor(1, "Profe", "Grillo", LocalDate.of(2000, 1, 1),LocalDate.of(2000, 1, 1), 2000);
		p = new Profesor(1, "Profe", "Grillo", 2000);
		try {
			p.jubilate();
			if(p.getEdad().isPresent())
				System.out.println(p.getEdad().get());
			else {
				System.out.println("Sin edad");
			}
		} catch (DemosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			throw new Exception("Esto fallo", e);
		}
		
	}
	public void genericos(PersonasRepository dao) {
		EjemplosGenericos.ElementoInt prov = new EjemplosGenericos.ElementoInt(28, "Madrid");
		EjemplosGenericos.ElementoChar genero = new EjemplosGenericos.ElementoChar('F', "Femenino");
//		EjemplosGenericos.Elemento<Character> ele = new EjemplosGenericos.Elemento<Character>('F', "Femenino");
//		ele = new EjemplosGenericos.Elemento<Integer>(28, "Madrid");
//		ele = new EjemplosGenericos.Elemento<Integer>("8", "Barcelona");
//		ele.setKey('a');
		System.out.println(prov.getKey() + " - " + prov.getValue());
		EjemplosGenericos.Elemento<Persona> lista = new EjemplosGenericos.Elemento<Persona>( 
				new Profesor(1, "Profe", "Grillo", LocalDate.of(2000, 1, 1),null, 2000), "Femenino");
		lista = new EjemplosGenericos.Elemento<Persona>( 
				new Alumno(2, "Alum", "Grillo", LocalDate.of(2000, 1, 1),null, 69), "Femenino");
		dao.getAll();
		EjemplosGenericos.ElementoEntero reg = new EjemplosGenericos.ElementoEntero(28, "Madrid");
		System.out.println(reg.key() + " - " + reg.value());
		Object o = 4; // new Integer(4)
		int i = (int)o; // o.getValue()
		Integer j = 5;
		i = i + j;
//		i = null;
		j = null;
	}

	public void tipos() {
		byte mal = 1;
		DiasDeLaSemana dia = DiasDeLaSemana.LUNES;
//		dia = DiasLaborables.LUNES;
		if(dia == DiasDeLaSemana.DOMINGO) {}
		// boolean b = switch (dia) { case DiasDeLaSemana.SABADO, DiasDeLaSemana.DOMINGO -> true; default-> false; };
		
		Persona persona = new Profesor(1, "Profe", "Grillo", LocalDate.of(2000, 1, 1),null, 2000);
		// persona.nombre = null;
//		persona.setFechaNacimiento(LocalDate.parse("2000-01-01"));
//		persona.setFechaNacimiento("2000-01-01");
		Date fechaDate = new Date();
		var s = persona.getNombre().replace("a", "o");
		Profesor profe = new Profesor(1, "Profe", "Grillo", LocalDate.of(2000, 1, 1),null, 2000);
		//profe.j
		Alumno alum = new Alumno(2, "Alum", "Grillo", LocalDate.of(2000, 1, 1),null, 69);
		alum.addNota(0, 1);
		System.out.println(alum.getNota(0));
		alum.getNotas()[0] = -10;
		out.println(alum.getNota(1));
		out.println(alum);
		out.println(profe.equals(alum));
		out.println("Salarios");
		Curso curso = new Curso(profe, 3000);
		out.println(curso.getProfesor().getSalario());
		profe.setSalario(0);;
		out.println(curso.getProfesor().getSalario());
		curso.getProfesor().setSalario(1000);
		out.println(curso.getProfesor().getSalario());
		Object o = new Principal();
		Grafico g = profe;
		g.pintate();
		g = alum;
		g.pintate();
		g = curso;
		g.pintate();
		if(o instanceof Grafico gg) {
			gg.pintate();
		} else {
			System.out.println("No lo se pintar");
		}
	}
	public void flujo() {
		int i = 1, rslt = 0;
		double d = 0;
		switch (i) {
		default:
		case 3:
			rslt += 1;
		case 2:
			rslt += 1;
		case 1:
			rslt += 1;
		}
		switch (i) {
		case 1, 3:
			rslt += 1;
			break;
		case 4:
		case 2:
			rslt += 2;
			break;
		default:
			rslt += 0;
			break;
		}
		i = 5;
		System.err.println(switch (i) {
		case 0 -> "ningun";
		case 1, 3, 5 -> "un";
		case 2 -> "dos";
		default -> "muchos";
		} + " elemento" + (i > 1 ? "s" : ""));
		var t = new int[8][8];
		for (int a = 0, b = 0; a < t.length && b < t[a].length; a++, b++) {

		}
		principal:
		for (var f : t) {
			for (var c : f) {
				break principal;
			}

		}
		boolean c1 = true, c2 = true, c3 = true, c4 = true;

		bucle:
		while (true) {
			// ...
			if (c1)
				break;
			// ...
			switch (i) {
			case 1, 3:
				rslt += 1;
				break bucle;
			case 4:
			case 2:
				rslt += 2;
				break;
			default:
				rslt += 0;
				break;
			}
			if (c2)
				break;
			// ...
			if (c3)
				break;
			// ...
		}
		while (c4) {
			// ...
			if (!c1) {
				// ...
				if (!c2) {
					// ...
					if (c3) {
						// ...
					}
				}
			}
		}
		while (c4) {
			// ...
			if (c1)
				continue;
			// ...
			if (c2)
				continue;
			// ...
			if (c3)
				continue;
			// ...
		}
	}

	public void operadores() {
		int i = 0, j, k;
		k = (j = i) + 1;
		boolean b1 = true, b2 = false;
		if (b2 = b1) {
			System.out.println("hecho");
		}
		if (b1) {
		}
		if (!b1) {
		}
		String s = "Hola", ss;
		k = i + j;
		ss = s + " mundo";
		System.out.println(ss);
		i = 1;
		j = 2;
		ss = s + j + i;
		System.out.println(ss);
		ss = "" + j + i + s;
		System.out.println(ss);
		System.out.println(3 / 2);
		System.out.println(3 / (double) 2);
		System.out.println(i / j);
		double x = 1, y = 0;
		System.out.println(((x / y) * 0) + 3);
		if (0.1 + 0.2 == 0.3) {
			System.out.println("si");
		} else {
			System.err.println("no");
		}
		System.err.println(0.1 + 0.2 != 0.3 ? "si" : "no");
		System.out.println(1 - 0.9);

		s += "";
		s = s + "";
		if (s == "") {
		}
		if (s != null && s.equals("")) {
		}
		if (s != null & s.equals("")) {
		}
		if ("".equals(s)) {
		}
		i = 1;
		j = --i;
		System.err.println(i + " elemento" + (i > 1 ? "s" : ""));
		Object o = new Principal();
		// ...
		if (o instanceof Principal) {
			Principal p = (Principal) o;
			System.out.println(p.suma(1, 1));
			System.out.println(p.resta(10, 1));
		}
		if (o instanceof Principal p) {
			System.out.println(p.suma(1, 1));
			System.out.println(p.resta(10, 1));
		}

	}

	public void tablas() {
		int[] t1;
		int t2[];
		t1 = new int[10];
		System.out.println(t1.length);
		System.out.println(t1[0]);
		System.out.println(t1[9]);
		String[] s = new String[5];
		s[0] = "";
		System.out.println(s[0] == null);
		int[][] tablero = new int[8][8];
		tablero[0][0] = 15;
		t2 = tablero[0];
		tablero[0] = tablero[1];
		tablero[1] = t2;
		tablero[2] = t1;
		tablero[3] = new int[3];
		;
		t1 = t2.clone();
	}

	public void variables() {
		int i = 0, j, k = 2;
		j = 1;
		k = i * j;
		String s = "Hola mundo";
		s.length();

		var x = "4";// (long)4;
		// i = (int)x;
		i = Integer.parseInt(x);
		x = "x" + i;
		x = Integer.toString(i);
		Object o = new Principal();
		if (o instanceof Principal) {
			((Principal) o).suma(1, 1);
		}
	}

	/**
	 * Suma dos valores enteros
	 * 
	 * @param o1 Operando 1 positivo
	 * @param o2 Operando 2
	 * @return suma de Operando 1 con Operando 2
	 */
	public int suma(int o1, int o2) {
		return o1 + o2;
	}

	/**
	 * Resta dos valores enteros
	 * 
	 * @param o1 Operando 1
	 * @param o2 Operando 2
	 * @return diferencia entre Operando 1 y Operando 2
	 */
	public int resta(int o1, int o2) {
		return o1 - o2;
	}
	public double avg(int obligatorio, int... valores) {
		// if(valores.length == 0) return 0;
		double acumulador = obligatorio;
		for(double valor: valores)
			acumulador += valor;
		return acumulador / (valores.length + 1);
	}

}
