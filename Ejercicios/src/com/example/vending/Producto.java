package com.example.vending;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class Producto {
    private int idProducto;
    private String nombre;
    private int unidadesStock;
    private int unidadesDisponibles;
    private int creditos;

    public Producto(int idProducto, String nombre, int unidadesStock, int creditos) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.unidadesStock = unidadesStock;
        this.unidadesDisponibles = unidadesStock;
        this.creditos = creditos;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getUnidadesStock() {
        return unidadesStock;
    }

    public int getUnidadesDispobles() {
        return unidadesDisponibles;
    }

    public int getCreditos() {
        return creditos;
    }

    public boolean hasExistencias() {
        return unidadesDisponibles > 0;
    }
    public void vende() {
        if(unidadesDisponibles == 0)
            throw new IllegalStateException("No hay unidades disponibles");
        this.unidadesDisponibles--;
    }

    public void repone(int unidades) {
        this.unidadesDisponibles += unidades;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idProducto;
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
        final Producto other = (Producto) obj;
        return this.idProducto == other.idProducto;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
