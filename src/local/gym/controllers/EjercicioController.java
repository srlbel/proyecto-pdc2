package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Ejercicio;

public class EjercicioController implements IController<Ejercicio> {
    private List<Ejercicio> ejercicios = new ArrayList<>();

    public EjercicioController(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    @Override
    public List<Ejercicio> getAll() {
        return ejercicios;
    }

    @Override
    public Ejercicio getById(int id) {
        for (Ejercicio ejercicio : ejercicios) {
            if (ejercicio.getId() == id) {
                return ejercicio;
            }
        }
        return null;
    }

    @Override
    public Ejercicio create(Ejercicio entity) {
        ejercicios.add(entity);
        return entity;
    }

    @Override
    public Ejercicio update(int id, Ejercicio entity) {
        for (int i = 0; i < ejercicios.size(); i++) {
            if (ejercicios.get(i).getId() == id) {
                ejercicios.set(i, entity);
                return entity;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return ejercicios.removeIf(e -> e.getId() == id);
    }
}
