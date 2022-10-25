package com.example;

import java.util.Random;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		var app = new Principal();
//		app.ejer1();
		app.ejer2();
	}

	public void ejer1() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Hola mundo");
		System.out.print("Dame valor: ");
		String cad = teclado.nextLine();
		System.out.println("Valor: " + cad);
		int i = Integer.parseInt(cad);
		var rnd = new Random();
		i = rnd.nextInt(10);
		System.out.println("Valor: " + rnd.nextInt(10));
		System.out.println("Valor: " + rnd.nextInt(10));
		System.out.println("Valor: " + rnd.nextInt(10));
		System.out.println("Valor: " + rnd.nextInt(10));
		System.out.println("Valor: " + rnd.nextInt(10));
	}

	public void ejer2() {

	}
}
