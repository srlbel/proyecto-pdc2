package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Persona;

public class UserController implements IController<Persona> {

    private List<Persona> personas = new ArrayList<>();

    @Override
    public List<Persona> getAll() {
        return personas;
    }

    @Override
    public Persona getById(int id) {
        for (Persona persona : personas) {
            if (persona.getId() == id) {
                return persona;
            }
        }

        return null;
    }

    @Override
    public Persona create(Persona entity) {
        personas.add(entity);
        return entity;
    }

    @Override
    public Persona update(int id, Persona entity) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getId() == id) {
                personas.set(i, entity);
                return entity;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return personas.removeIf(p -> p.getId() == id);
    }
}
