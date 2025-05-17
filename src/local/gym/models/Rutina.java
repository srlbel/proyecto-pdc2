package models;

import java.util.ArrayList;
import java.util.List;

public class Rutina {
    private String nombreRutina;
    private List<Ejercicio> ejercicios;

    // Constructor
    public Rutina(String nombreRutina) {
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

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    // Método para mostrar la rutina completa
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rutina: ").append(nombreRutina).append("\n");
        for (Ejercicio ejercicio : ejercicios) {
            sb.append("- ").append(ejercicio.toString()).append("\n");
        }
        return sb.toString();
    }
}
