
package com.mycompany.chicavanidosajava.repositorio;

import com.mycompany.chicavanidosajava.modelo.Producto;
import java.util.ArrayList;

/**
 * Administra los productos de la tienda Chica Vanidosa.
 * Permite realizar las operaciones CRUD.
 */
public class ProductoRepositorio {

    private ArrayList<Producto> productos = new ArrayList<>();

    // CREATE: guardar un producto nuevo
    public boolean guardar(Producto producto) {

        // No permite referencias repetidas
        if (buscar(producto.getReferencia()) != null) {
            return false;
        }

        productos.add(producto);
        return true;
    }

    // READ: buscar un producto por referencia
    public Producto buscar(String referencia) {

        for (Producto producto : productos) {
            if (producto.getReferencia().equalsIgnoreCase(referencia)) {
                return producto;
            }
        }

        return null;
    }

    // READ: obtener todos los productos
    public ArrayList<Producto> listar() {
        return new ArrayList<>(productos);
    }

    // UPDATE: actualizar los datos de un producto
    public boolean actualizar(Producto productoActualizado) {

        Producto producto = buscar(productoActualizado.getReferencia());

        if (producto == null) {
            return false;
        }

        producto.setNombre(productoActualizado.getNombre());
        producto.setTalla(productoActualizado.getTalla());
        producto.setColor(productoActualizado.getColor());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setStock(productoActualizado.getStock());

        return true;
    }

    // DELETE: eliminar un producto
    public boolean eliminar(String referencia) {

        Producto producto = buscar(referencia);

        if (producto == null) {
            return false;
        }

        productos.remove(producto);
        return true;
    }
}
