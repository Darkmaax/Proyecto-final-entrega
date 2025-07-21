package com.example.demo.controller;

import com.example.demo.entity.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    //datos
    private ArrayList<Producto> productos;

    public ProductController() {
        this.productos = new ArrayList<>();
        agregarProductosDeEjemplo();
    }

    //endpoints
    @PostMapping("/")
    public String createProduct(@RequestBody Producto producto){
        return this.agregarProducto(producto);
    }
    //metodos
    public String agregarProducto(Producto producto) {
        productos.add(producto);

        return "Producto agregado correctamente ✅ \n ID del producto: " + producto.getId();
    }

    @GetMapping("/list")
    public List<Producto> obtenerListadoProductos(){
        return this.listarProductos();
    }

    private List<Producto> listarProductos() {
        return this.productos;
    }

    @GetMapping("/find")
    public List<Producto> obtenerProductos(@RequestParam String nombreBusqueda){
        return this.buscarProducto(nombreBusqueda);
    }
    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id){
        return this.buscarPorId(id);
    }
    @PutMapping("/{id}")
    public Producto editarPrecioProducto(@PathVariable Long id,@RequestParam Double nuevoPrecio,@RequestParam String nuevoNombre){
        return this.editarProducto(id, nuevoPrecio, nuevoNombre);
    }

    @DeleteMapping("/{id}")
    public Producto borrarProducto(@PathVariable Long id){
        return this.eliminarProducto(id);
    }

    private Producto editarProducto(Long id, Double nuevoPrecio, String nuevoNombre){
        Producto producto = this.buscarPorId(id);

        if (producto == null) {
            return null;
        }

        producto.setPrecio(nuevoPrecio);
        producto.setNombre(nuevoNombre);

        return producto;
    }

    private Producto eliminarProducto(Long id) {
        Producto producto = this.buscarPorId(id);

        if (producto == null){
            return null;
        }
        this.productos.remove(producto);

        return producto;
    }

    private ArrayList<Producto> buscarProducto(String busqueda) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        int contadorDeProductos = 0;
        for (Producto producto : productos){
            if (producto.contieneNombre(busqueda)){
                productosEncontrados.add(producto);
                contadorDeProductos++;

            }
        }
        return productosEncontrados;
    }

    private Producto buscarPorId(Long id) {
        for (Producto producto : productos){
            if (producto.getId() == id){
                return producto;
            }
        }
        return null;
    }

    public void agregarProductosDeEjemplo() {
        productos.add(new Producto("Monitor", 300000, 20));
        productos.add(new Producto("Tarjeta gráfica", 500000, 10));
        productos.add(new Producto("Gabinete", 100000, 30));
        productos.add(new Producto("Teclado mecánico", 45000, 50));
        productos.add(new Producto("Mouse gamer", 35000, 40));
        productos.add(new Producto("Auriculares inalámbricos", 80000, 25));
        productos.add(new Producto("Notebook", 1000000, 15));
        productos.add(new Producto("Tablet", 250000, 12));
        productos.add(new Producto("Smartphone", 600000, 18));
        productos.add(new Producto("Disco SSD 1TB", 120000, 22));
        productos.add(new Producto("Memoria RAM 16GB", 70000, 35));
        productos.add(new Producto("Procesador Intel i7", 180000, 10));
        productos.add(new Producto("Motherboard", 150000, 14));
        productos.add(new Producto("Fuente de poder 650W", 95000, 16));
        productos.add(new Producto("Webcam HD", 30000, 28));
        productos.add(new Producto("Impresora multifunción", 160000, 8));
        productos.add(new Producto("Parlantes Bluetooth", 55000, 32));
        productos.add(new Producto("Cámara de seguridad", 90000, 20));
        productos.add(new Producto("Router WiFi", 60000, 25));
        productos.add(new Producto("Smartwatch", 500000, 19));
    }

}
