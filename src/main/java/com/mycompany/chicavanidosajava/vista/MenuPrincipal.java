
package com.mycompany.chicavanidosajava.vista;

import com.mycompany.chicavanidosajava.controlador.ClienteControlador;
import com.mycompany.chicavanidosajava.controlador.ProductoControlador;
import com.mycompany.chicavanidosajava.modelo.Cliente;
import com.mycompany.chicavanidosajava.modelo.Producto;
import java.util.Scanner;

/**
 * Menú principal de Chica Vanidosa.
 * Permite gestionar productos y clientes.
 */
public class MenuPrincipal {

    private static Scanner teclado = new Scanner(System.in);
    private static ProductoControlador productos = new ProductoControlador();
    private static ClienteControlador clientes = new ClienteControlador();

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n===== CHICA VANIDOSA =====");
            System.out.println("1. Gestionar productos");
            System.out.println("2. Gestionar clientes");
            System.out.println("0. Salir");

            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    menuProductos();
                    break;
                case 2:
                    menuClientes();
                    break;
                case 0:
                    System.out.println("Gracias por usar Chica Vanidosa.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    // Menú CRUD de productos
    private static void menuProductos() {
        int opcion;

        do {
            System.out.println("\n===== PRODUCTOS =====");
            System.out.println("1. Guardar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Listar productos");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    guardarProducto();
                    break;
                case 2:
                    buscarProducto();
                    break;
                case 3:
                    listarProductos();
                    break;
                case 4:
                    actualizarProducto();
                    break;
                case 5:
                    eliminarProducto();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    // Menú CRUD de clientes
    private static void menuClientes() {
        int opcion;

        do {
            System.out.println("\n===== CLIENTES =====");
            System.out.println("1. Guardar cliente");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Listar clientes");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    guardarCliente();
                    break;
                case 2:
                    buscarCliente();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    actualizarCliente();
                    break;
                case 5:
                    eliminarCliente();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    // -------- OPERACIONES DE PRODUCTOS --------

    private static void guardarProducto() {
        System.out.println("\n--- Guardar producto ---");

        String referencia = leerTexto("Referencia: ");
        String nombre = leerTexto("Nombre: ");
        String talla = leerTexto("Talla: ");
        String color = leerTexto("Color: ");
        double precio = leerDouble("Precio: ");
        int stock = leerEntero("Stock: ");

        boolean resultado = productos.guardarProducto(
                referencia, nombre, talla, color, precio, stock
        );

        System.out.println(resultado
                ? "Producto guardado correctamente."
                : "No se pudo guardar. Verifique los datos o la referencia.");
    }

    private static void buscarProducto() {
        String referencia = leerTexto("Referencia a buscar: ");
        Producto producto = productos.buscarProducto(referencia);

        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void listarProductos() {
        System.out.println("\n--- Inventario de productos ---");

        if (productos.listarProductos().isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto producto : productos.listarProductos()) {
                System.out.println(producto);
            }
        }
    }

    private static void actualizarProducto() {
        System.out.println("\n--- Actualizar producto ---");

        String referencia = leerTexto("Referencia existente: ");

        if (productos.buscarProducto(referencia) == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        String nombre = leerTexto("Nuevo nombre: ");
        String talla = leerTexto("Nueva talla: ");
        String color = leerTexto("Nuevo color: ");
        double precio = leerDouble("Nuevo precio: ");
        int stock = leerEntero("Nuevo stock: ");

        boolean resultado = productos.actualizarProducto(
                referencia, nombre, talla, color, precio, stock
        );

        System.out.println(resultado
                ? "Producto actualizado correctamente."
                : "No se pudo actualizar el producto.");
    }

    private static void eliminarProducto() {
        String referencia = leerTexto("Referencia a eliminar: ");

        boolean resultado = productos.eliminarProducto(referencia);

        System.out.println(resultado
                ? "Producto eliminado correctamente."
                : "Producto no encontrado.");
    }

    // -------- OPERACIONES DE CLIENTES --------

    private static void guardarCliente() {
        System.out.println("\n--- Guardar cliente ---");

        int id = leerEntero("ID: ");
        String nombre = leerTexto("Nombre: ");
        String apellido = leerTexto("Apellido: ");
        String telefono = leerTexto("Telefono: ");
        String correo = leerTexto("Correo: ");
        String direccion = leerTexto("Direccion: ");

        boolean resultado = clientes.guardarCliente(
                id, nombre, apellido, telefono, correo, direccion
        );

        System.out.println(resultado
                ? "Cliente guardado correctamente."
                : "No se pudo guardar. Verifique los datos o el ID.");
    }

    private static void buscarCliente() {
        int id = leerEntero("ID del cliente: ");
        Cliente cliente = clientes.buscarCliente(id);

        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void listarClientes() {
        System.out.println("\n--- Clientes registrados ---");

        if (clientes.listarClientes().isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente cliente : clientes.listarClientes()) {
                System.out.println(cliente);
            }
        }
    }

    private static void actualizarCliente() {
        System.out.println("\n--- Actualizar cliente ---");

        int id = leerEntero("ID existente: ");

        if (clientes.buscarCliente(id) == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        String nombre = leerTexto("Nuevo nombre: ");
        String apellido = leerTexto("Nuevo apellido: ");
        String telefono = leerTexto("Nuevo telefono: ");
        String correo = leerTexto("Nuevo correo: ");
        String direccion = leerTexto("Nueva direccion: ");

        boolean resultado = clientes.actualizarCliente(
                id, nombre, apellido, telefono, correo, direccion
        );

        System.out.println(resultado
                ? "Cliente actualizado correctamente."
                : "No se pudo actualizar el cliente.");
    }

    private static void eliminarCliente() {
        int id = leerEntero("ID del cliente a eliminar: ");

        boolean resultado = clientes.eliminarCliente(id);

        System.out.println(resultado
                ? "Cliente eliminado correctamente."
                : "Cliente no encontrado.");
    }

    // -------- LECTURA DE DATOS --------

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return teclado.nextLine();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(leerTexto(mensaje));
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(
                        leerTexto(mensaje).replace(",", ".")
                );
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un precio valido.");
            }
        }
    }
}
