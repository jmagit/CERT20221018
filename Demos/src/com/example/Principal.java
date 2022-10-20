package com.example;

/**
 * Clase principal con las demos del curso
 * @author Javier
 * @version 1.0.0
 * @since 17
 *
 */
public class Principal {

	/**
	 * Punto de arranque de la aplicacion
	 * @param args -d para lo que sea
	 */
	public static void main(String[] args) {
		var app = new Principal();
		
		//System.out.println(app.suma(2, 2));
		app.variables();

	}
	
	public void variables() {
		int i = 0, j, k =2;
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
		if(o instanceof Principal) {
			((Principal)o).suma(1, 1);
		}
	}
	
	/**
	 * Suma dos valores enteros
	 * @param o1 Operando 1 positivo
	 * @param o2 Operando 2
	 * @return suma de Operando 1 con Operando 2
	 */
	public int suma(int o1, int o2) {
		return o1 + o2;
	}
	
	/**
	 * Resta dos valores enteros
	 * @param o1 Operando 1
	 * @param o2 Operando 2
	 * @return diferencia entre Operando 1 y Operando 2
	 */
	public int resta(int o1, int o2) {
		return o1 - o2;
	}

}
