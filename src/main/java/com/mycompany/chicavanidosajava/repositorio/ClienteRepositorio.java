
package com.mycompany.chicavanidosajava.repositorio;

import com.mycompany.chicavanidosajava.modelo.Cliente;
import java.util.ArrayList;

/**
 * Repositorio para administrar los clientes
 * de la tienda Chica Vanidosa.
 * Permite realizar las operaciones CRUD.
 */
public class ClienteRepositorio {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    // CREATE: guardar un cliente nuevo
    public boolean guardar(Cliente cliente) {

        // Verificar que el ID no esté repetido
        if (buscar(cliente.getId()) != null) {
            return false;
        }

        clientes.add(cliente);
        return true;
    }

    // READ: buscar un cliente por su ID
    public Cliente buscar(int id) {

        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }

        return null;
    }

    // READ: mostrar todos los clientes
    public ArrayList<Cliente> listar() {
        return new ArrayList<>(clientes);
    }

    // UPDATE: actualizar los datos de un cliente
    public boolean actualizar(Cliente clienteActualizado) {

        Cliente cliente = buscar(clienteActualizado.getId());

        if (cliente == null) {
            return false;
        }

        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setApellido(clienteActualizado.getApellido());
        cliente.setTelefono(clienteActualizado.getTelefono());
        cliente.setCorreo(clienteActualizado.getCorreo());
        cliente.setDireccion(clienteActualizado.getDireccion());

        return true;
    }

    // DELETE: eliminar un cliente por su ID
    public boolean eliminar(int id) {

        Cliente cliente = buscar(id);

        if (cliente == null) {
            return false;
        }

        clientes.remove(cliente);
        return true;
    }
}
