package com.example.demo.entity;

public class Producto {
    private static int ID_SIG = 1;
    private final int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(){
        this.id = ID_SIG;
        ID_SIG++;
    }

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.id = ID_SIG;
        ID_SIG++;
    }

    public void mostrarInfo(){
        System.out.printf("""
                Id: %s
                Nombre: %s
                Precio: %s
                Stock: %s
                """, this.id, this.nombre, this.precio, this.stock);
    }


    public boolean contieneNombre(String busqueda){
        String nombreMinuscula = this.nombre.toLowerCase();
        return nombreMinuscula.contains(busqueda.toLowerCase());
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
