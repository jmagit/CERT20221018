package com.example.vending;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Javier
 */
public class Maquina {

    Set<Empleado> usuarios = new HashSet<>();
    Set<Producto> productos = new HashSet<>();
    List<Venta> ventas = new ArrayList<>();

    public Maquina() {
        usuarios.add(new Empleado("1", "1111", 100));
        usuarios.add(new Empleado("2", "2222", 200));
        productos.add(new Producto(1, "Refresco", 50, 3));
        productos.add(new Producto(2, "Chocolatina", 100, 5));
        productos.add(new Producto(3, "Cafe", 300, 1));
    }

    public void reiniciaCreditos() {
        usuarios.stream()
                .filter(e -> e.getCreditosDisponibles() < e.getCreditosAsignados())
                .forEach(e -> e.reiniciaCredito());
    }

    public void reponerTodo() {
    	productos.stream()
    		.filter(p -> p.getUnidadesDispobles() < p.getUnidadesStock())
    		.forEach(p -> p.repone(p.getUnidadesStock()-p.getUnidadesDispobles()));
    }

    public void vender(String numeroPersonal, String pin, int idProducto) {
        var empleado = usuarios.stream().filter(e -> e.getNumeroPersonal().equals(numeroPersonal)).findFirst();
        if (empleado.isEmpty()) {
            throw new IllegalArgumentException("Empleado no encontrado");
        }
        var producto = productos.stream().filter(e -> e.getIdProducto() == idProducto).findFirst();
        if (producto.isEmpty()) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
        ventas.add(Venta.operacion(producto.get(), empleado.get(), pin));
    }

    public List<Map<Integer, Integer>> stock() {
        return productos.stream()
                .map(p -> Map.of(p.getIdProducto(), p.getUnidadesDispobles()))
                .toList();
    }

    public List<Map<Integer, Integer>> consumos() {
        return productos.stream()
                .filter(p -> p.getUnidadesStock() > p.getUnidadesDispobles())
                .map(p -> Map.of(p.getIdProducto(), p.getUnidadesStock() - p.getUnidadesDispobles()))
                .toList();
    }

    public List<Map<String, Integer>> saldos() {
        return usuarios.stream()
                .map(p -> Map.of(p.getNumeroPersonal(), p.getCreditosDisponibles()))
                .toList();
    }
}
