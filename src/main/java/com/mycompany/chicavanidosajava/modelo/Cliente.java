
package com.mycompany.chicavanidosajava.modelo;

/**
 * Representa un cliente de la tienda Chica Vanidosa.
 */
public class Cliente {

    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String direccion;

    // Constructor para crear un cliente
    public Cliente(int id, String nombre, String apellido,
                   String telefono, String correo, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    // Métodos para consultar información
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    // Métodos para modificar información
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Muestra los datos del cliente
    @Override
    public String toString() {
        return "ID: " + id
                + " | Nombre: " + nombre + " " + apellido
                + " | Teléfono: " + telefono
                + " | Correo: " + correo
                + " | Dirección: " + direccion;
    }
}
