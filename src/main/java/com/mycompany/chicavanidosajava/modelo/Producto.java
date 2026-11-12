
package com.mycompany.chicavanidosajava.modelo;

/**
 * Representa un producto de la tienda Chica Vanidosa.
 */
public class Producto {

    private String referencia;
    private String nombre;
    private String talla;
    private String color;
    private double precio;
    private int stock;

    // Constructor para crear un producto
    public Producto(String referencia, String nombre,
                    String talla, String color,
                    double precio, int stock) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
    }

    // Métodos para consultar los datos
    public String getReferencia() {
        return referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTalla() {
        return talla;
    }

    public String getColor() {
        return color;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    // Métodos para modificar los datos
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Muestra la información del producto
    @Override
    public String toString() {
        return referencia + " - " + nombre
                + " | Talla: " + talla
                + " | Color: " + color
                + " | Precio: $" + precio
                + " | Stock: " + stock;
    }
}
