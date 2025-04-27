package models;

public class Implemento {

    private int id;
    private String nombre;
    private String ubicacion;
    private int cantidad;

    public Implemento(int id, String nombre, String ubicacion, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.cantidad = cantidad;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void mostrarDatos() {
        System.out.println("Informacion de Implementos:");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("---");
    }
}
