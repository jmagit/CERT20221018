/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.juegos;

/**
 * Excepciones propias de las reglas de los juegos
 * 
 * @author Javier
 */
public class JuegoException extends Exception {

    public JuegoException(String message) {
        super(message);
    }

    public JuegoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
