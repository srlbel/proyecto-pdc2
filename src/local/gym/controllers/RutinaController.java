package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Rutina;

public class RutinaController implements IController<Rutina> {
    private List<Rutina> rutinas = new ArrayList<>();

    public RutinaController(List<Rutina> rutinas) {
        this.rutinas = rutinas;
    }

    @Override
    public List<Rutina> getAll() {
        return rutinas;
    }

    @Override
    public Rutina getById(int id) {
        for (Rutina rutina : rutinas) {
            if (rutina.getId() == id) {
                return rutina;
            }
        }

        return null;
    }

    @Override
    public Rutina create(Rutina entity) {
        rutinas.add(entity);
        return entity;
    }

    @Override
    public Rutina update(int id, Rutina entity) {
        for (int i = 0; i < rutinas.size(); i++) {
            if (rutinas.get(i).getId() == id) {
                rutinas.set(i, entity);
                return entity;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return rutinas.removeIf(r -> r.getId() == id);
    }
}
