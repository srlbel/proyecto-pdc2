package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import models.Cliente;
import models.Entrenador;
import models.Persona;
import models.Rutina;
import models.Turno;

public class EmpleadoController implements IController<Entrenador> {

    private List<Persona> personas = new ArrayList<>();

    public EmpleadoController(List<Persona> personas) {
        this.personas = personas.stream()
                .filter(p -> p instanceof Entrenador)
                .collect(Collectors.toList());
    }

    public List<Entrenador> getAllEntrenadores() {
        return personas.stream()
                .filter(p -> p instanceof Entrenador)
                .map(p -> (Entrenador) p)
                .collect(Collectors.toList());
    }

    @Override
    public List<Entrenador> getAll() {
        return getAllEntrenadores();
    }

    public Entrenador getEntrenadorById(int id) {
        for (Persona persona : personas) {
            if (persona instanceof Entrenador && persona.getId() == id) {
                return (Entrenador) persona;
            }
        }
        return null;
    }

    @Override
    public Entrenador getById(int id) {
        return getEntrenadorById(id);
    }

    public Entrenador createEntrenador(Entrenador entrenador) {
        if (entrenador != null) {
            personas.add(entrenador);
            return entrenador;
        }
        return null;
    }

    public boolean createEntrenador(int id, String nombre, String telefono, String cedula,
            String email, double salario, Turno turno) {
        try {
            Entrenador newEntrenador = new Entrenador(
                    id,
                    nombre,
                    telefono,
                    cedula,
                    email,
                    salario,
                    turno);
            personas.add(newEntrenador);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Entrenador create(Entrenador entity) {
        return createEntrenador(entity);
    }

    public Entrenador updateEntrenador(int id, Entrenador updatedEntrenador) {
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            if (persona instanceof Entrenador && persona.getId() == id) {
                personas.set(i, updatedEntrenador);
                return updatedEntrenador;
            }
        }
        return null;
    }

    public boolean updateEntrenador(int id, String nombre, String telefono, String cedula,
            String email, double salario, Turno turno) {
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            if (persona instanceof Entrenador && persona.getId() == id) {
                Entrenador entrenadorToUpdate = (Entrenador) persona;
                entrenadorToUpdate.setNombre(nombre);
                entrenadorToUpdate.setTelefono(telefono);
                entrenadorToUpdate.setCedula(cedula);
                entrenadorToUpdate.setEmail(email);
                entrenadorToUpdate.setSalario(salario);
                entrenadorToUpdate.setTurno(turno);
                return true;
            }
        }
        return false;
    }

    @Override
    public Entrenador update(int id, Entrenador entity) {
        if (entity instanceof Entrenador) {
            return updateEntrenador(id, (Entrenador) entity);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return personas.removeIf(p -> p instanceof Entrenador && p.getId() == id);
    }

    public boolean addRutinaToClient(int entrenadorId, UserController clienteController,
            int clienteId, Rutina rutina) {
        Entrenador entrenador = getEntrenadorById(entrenadorId);
        Cliente cliente = clienteController.getClienteById(clienteId);

        if (entrenador != null && cliente != null && rutina != null) {
            entrenador.agregarRutinaACliente(rutina, cliente);
            return true;
        }
        return false;
    }
}
