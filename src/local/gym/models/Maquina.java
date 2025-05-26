package models;

import java.text.SimpleDateFormat;

public class Maquina {

    private int id;
    private String nombre;
    private String ubicacion;
    private boolean enMantenimiento;

    public Maquina(
            int id,
            String nombre,
            String ubicacion,
            boolean enMantenimiento) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.enMantenimiento = enMantenimiento;
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

    public boolean getEnMantenimiento() {
        return this.enMantenimiento;
    }

    public void setEnMantenimiento(boolean enMantenimiento) {
        this.enMantenimiento = enMantenimiento;
    }

    @Override
    public String toString() {
        return this.nombre + "( M: " + this.enMantenimiento + " )";
    }
}
