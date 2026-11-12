
package com.mycompany.chicavanidosajava.controlador;

import com.mycompany.chicavanidosajava.modelo.Cliente;
import com.mycompany.chicavanidosajava.repositorio.ClienteRepositorio;
import java.util.ArrayList;

/**
 * Controlador de clientes de la tienda Chica Vanidosa.
 * Permite gestionar las operaciones CRUD.
 */
public class ClienteControlador {

    private ClienteRepositorio repositorio;

    // Constructor del controlador
    public ClienteControlador() {
        repositorio = new ClienteRepositorio();
    }

    // CREATE: guardar un cliente nuevo
    public boolean guardarCliente(int id, String nombre,
            String apellido, String telefono,
            String correo, String direccion) {

        // Validar los campos obligatorios
        if (id <= 0
                || nombre == null || nombre.trim().isEmpty()
                || apellido == null || apellido.trim().isEmpty()
                || direccion == null || direccion.trim().isEmpty()) {
            return false;
        }

        Cliente cliente = new Cliente(
                id, nombre, apellido, telefono, correo, direccion
        );

        return repositorio.guardar(cliente);
    }

    // READ: buscar un cliente por su ID
    public Cliente buscarCliente(int id) {
        return repositorio.buscar(id);
    }

    // READ: listar todos los clientes
    public ArrayList<Cliente> listarClientes() {
        return repositorio.listar();
    }

    // UPDATE: actualizar un cliente
    public boolean actualizarCliente(int id, String nombre,
            String apellido, String telefono,
            String correo, String direccion) {

        // Validar los campos obligatorios
        if (id <= 0
                || nombre == null || nombre.trim().isEmpty()
                || apellido == null || apellido.trim().isEmpty()
                || direccion == null || direccion.trim().isEmpty()) {
            return false;
        }

        Cliente cliente = new Cliente(
                id, nombre, apellido, telefono, correo, direccion
        );

        return repositorio.actualizar(cliente);
    }

    // DELETE: eliminar un cliente por su ID
    public boolean eliminarCliente(int id) {
        return repositorio.eliminar(id);
    }
}
