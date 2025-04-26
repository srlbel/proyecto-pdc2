package controllers;

import models.Persona;

public class UserController<Persona> implements IController<Persona> {
    private List<Persona> personas;

    public List<Persona> getPersonas() {
        return personas;
    }

}
