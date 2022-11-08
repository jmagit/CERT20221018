package com.example.vending;

import java.util.Date;

/**
 *
 * @author Javier
 */
public class Venta {
    private Empleado empleado;
    private Producto producto;
    private Date fecha = new Date();

    private Venta(Empleado empleado, Producto producto) {
        this.empleado = empleado;
        this.producto = producto;
    }

    public Empleado getEmpleado() {
        return empleado.clone();
    }

    public Producto getProducto() {
        return (Producto)producto.clone();
    }

    public Date getFecha() {
        return (Date)fecha.clone();
    }
    
    public static Venta operacion(Producto producto, Empleado empleado, String pin) {
        if(empleado == null || producto == null || pin == null)
            throw new IllegalArgumentException();
        if(!producto.hasExistencias())
            throw new IllegalStateException("No hay existencias");
        if(!empleado.hasCreditoDisponible(producto.getCreditos()))
            throw new IllegalStateException("No tienes suficientes creditos");
        empleado.compra(pin, producto.getCreditos());
        producto.vende();
        return new Venta(empleado, producto);
    }
}
