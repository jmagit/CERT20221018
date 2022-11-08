package com.example.vending;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class Empleado implements Cloneable {
    private String numeroPersonal;
    private String pin;
    private int creditosAsignados;
    private int creditosDisponibles;

    public Empleado(String numeroPersonal, String pin, int creditosAsignados) {
        this.numeroPersonal = numeroPersonal;
        this.pin = pin;
        this.creditosAsignados = creditosAsignados;
        this.creditosDisponibles = creditosAsignados;
    }

    public String getNumeroPersonal() {
        return numeroPersonal;
    }

    public int getCreditosAsignados() {
        return creditosAsignados;
    }

    public int getCreditosDisponibles() {
        return creditosDisponibles;
    }
    
    public boolean hasCreditoDisponible() {
        return creditosDisponibles > 0;
    }
    
    public boolean hasCreditoDisponible(int coste) {
        return creditosDisponibles > coste;
    }
    
    public void compra(String pin, int coste) {
        if(!this.pin.equals(pin))
            throw new IllegalStateException("PIN incorrecto");
        if(coste > creditosDisponibles)
            throw new IllegalStateException("No queda saldo");
        creditosDisponibles -= coste;
    }
    
    public void reiniciaCredito() {
        creditosDisponibles = creditosAsignados;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.numeroPersonal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        return Objects.equals(this.numeroPersonal, other.numeroPersonal);
    }

    @Override
    public Empleado clone() {
        return new Empleado(numeroPersonal, pin, creditosAsignados);
    }
    
    
}
