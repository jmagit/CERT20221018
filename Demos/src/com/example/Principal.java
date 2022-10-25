package com.example;

/**
 * Clase principal con las demos del curso
 * 
 * @author Javier
 * @version 1.0.0
 * @since 17
 *
 */
public class Principal {

	/**
	 * Punto de arranque de la aplicacion
	 * 
	 * @param args -d para lo que sea
	 */
	public static void main(String[] args) {
		var app = new Principal();

		// System.out.println(app.suma(2, 2));
		app.flujo();

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

}
