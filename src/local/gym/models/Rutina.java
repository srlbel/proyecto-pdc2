package models;

import java.util.ArrayList;
import java.util.List;

public class Rutina {
    private int id;
    private String nombreRutina;
    private List<Ejercicio> ejercicios;

    // Constructor
    public Rutina(int id, String nombreRutina) {
        this.id = id;
        this.nombreRutina = nombreRutina;
        this.ejercicios = new ArrayList<>();
    }

    // Método para agregar ejercicios a la rutina
    public void agregarEjercicio(Ejercicio ejercicio) {
        ejercicios.add(ejercicio);
    }

    // Getters y Setters
    public String getNombreRutina() {
        return nombreRutina;
    }

    public void setNombreRutina(String nombreRutina) {
        this.nombreRutina = nombreRutina;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public int getId() {
        return id;
    }
}
