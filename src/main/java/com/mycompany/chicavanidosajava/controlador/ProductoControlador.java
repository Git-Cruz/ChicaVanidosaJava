
package com.mycompany.chicavanidosajava.controlador;

import com.mycompany.chicavanidosajava.modelo.Producto;
import com.mycompany.chicavanidosajava.repositorio.ProductoRepositorio;
import java.util.ArrayList;

/**
 * Controlador de productos de Chica Vanidosa.
 * Comunica el programa con el repositorio.
 */
public class ProductoControlador {

    private ProductoRepositorio repositorio;

    // Constructor del controlador
    public ProductoControlador() {
        repositorio = new ProductoRepositorio();
    }

    // CREATE: registrar un producto
    public boolean guardarProducto(String referencia, String nombre,
            String talla, String color, double precio, int stock) {

        if (referencia == null || referencia.trim().isEmpty()
                || nombre == null || nombre.trim().isEmpty()
                || color == null || color.trim().isEmpty()
                || precio < 0 || stock < 0) {
            return false;
        }

        Producto producto = new Producto(
                referencia, nombre, talla, color, precio, stock
        );

        return repositorio.guardar(producto);
    }

    // READ: buscar un producto
    public Producto buscarProducto(String referencia) {
        return repositorio.buscar(referencia);
    }

    // READ: mostrar todos los productos
    public ArrayList<Producto> listarProductos() {
        return repositorio.listar();
    }

    // UPDATE: actualizar un producto
    public boolean actualizarProducto(String referencia, String nombre,
            String talla, String color, double precio, int stock) {

        if (referencia == null || referencia.trim().isEmpty()
                || nombre == null || nombre.trim().isEmpty()
                || color == null || color.trim().isEmpty()
                || precio < 0 || stock < 0) {
            return false;
        }

        Producto producto = new Producto(
                referencia, nombre, talla, color, precio, stock
        );

        return repositorio.actualizar(producto);
    }

    // DELETE: eliminar un producto
    public boolean eliminarProducto(String referencia) {
        return repositorio.eliminar(referencia);
    }
}
