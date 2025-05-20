package models;

import java.util.Optional;

public class Ejercicio {
    private int id;
    private String nombre;
    private String descripcion;
    private int repeticiones;
    private int series;
    private Optional<Maquina> maquina;
    private Optional<Implemento> implemento;

    // Constructor
    public Ejercicio(int id, String nombre, String descripcion, int repeticiones, int series) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.repeticiones = repeticiones;
        this.series = series;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMaquina(Optional<Maquina> maquina) {
        this.maquina = maquina;
    }

    public void setImplemento(Optional<Implemento> implemento) {
        this.implemento = implemento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Optional<Maquina> getMaquina() {
        return maquina;
    }

    public Optional<Implemento> getImplemento() {
        return implemento;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
