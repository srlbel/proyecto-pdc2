package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import models.Cliente;
import models.Persona;
import models.Rutina;

public class UserController implements IController<Cliente> {

    private List<Persona> personas = new ArrayList<>();

    public UserController(List<Persona> personas) {
        this.personas = personas.stream()
                .filter(p -> p instanceof Cliente)
                .collect(Collectors.toList());
    }

    public List<Cliente> getAllClientes() {
        return personas.stream()
                .filter(p -> p instanceof Cliente)
                .map(p -> (Cliente) p)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cliente> getAll() {
        return getAllClientes();
    }

    public Cliente getClienteById(int id) {
        for (Persona persona : personas) {
            if (persona instanceof Cliente && persona.getId() == id) {
                return (Cliente) persona;
            }
        }
        return null;
    }

    @Override
    public Cliente getById(int id) {
        return getClienteById(id);
    }

    public Cliente createCliente(Cliente cliente) {
        personas.add(cliente); // Add the Cliente object to the list
        return cliente;
    }

    public boolean createCliente(int id, String nombre, String telefono, String cedula, String email,
            double mensualidad,
            int diaRenovacion, boolean haPagado) {
        try {
            Cliente newCliente = new Cliente(
                    id,
                    nombre,
                    telefono,
                    cedula,
                    email,
                    mensualidad,
                    diaRenovacion,
                    haPagado,
                    null);
            personas.add(newCliente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Cliente create(Cliente entity) {
        return createCliente((Cliente) entity);
    }

    public Cliente updateCliente(int id, Cliente updatedCliente) {
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            if (persona instanceof Cliente && persona.getId() == id) {
                personas.set(i, updatedCliente);
                return updatedCliente;
            }
        }
        return null;
    }

    public boolean updateCliente(int id, String nombre, String telefono, String cedula, String email,
            double mensualidad,
            int diaRenovacion, boolean haPagado) {
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            if (persona instanceof Cliente && persona.getId() == id) {
                Cliente clienteToUpdate = (Cliente) persona;
                clienteToUpdate.setNombre(nombre);
                clienteToUpdate.setTelefono(telefono);
                clienteToUpdate.setCedula(cedula);
                clienteToUpdate.setEmail(email);
                clienteToUpdate.setMensualidad(mensualidad);
                clienteToUpdate.setDiaRenovacion(diaRenovacion);
                clienteToUpdate.setHaPagado(haPagado);
                return true;
            }
        }
        return false;
    }

    @Override
    public Cliente update(int id, Cliente entity) {
        if (entity instanceof Cliente) {
            return updateCliente(id, (Cliente) entity);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return personas.removeIf(p -> p instanceof Cliente && p.getId() == id);
    }

    public List<Rutina> getRutinasByClienteId(int clienteId) {
        Cliente cliente = getClienteById(clienteId);
        if (cliente != null) {
            return cliente.getRutinas();
        }
        return null;
    }
}
