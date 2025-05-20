package controllers;

import java.util.List;

import models.Implemento;
import models.Inventario;

public class ImplementoController implements IController<Implemento> {
    private Inventario inventario;

    public ImplementoController(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public List<Implemento> getAll() {
        return inventario.getImplementos();
    }

    @Override
    public Implemento getById(int id) {
        for (Implemento implemento : inventario.getImplementos()) {
            if (implemento.getId() == id) {
                return implemento;
            }
        }
        return null;
    }

    @Override
    public Implemento create(Implemento entity) {
        inventario.agregarImplemento(entity);
        return entity;
    }

    @Override
    public Implemento update(int id, Implemento entity) {
        List<Implemento> implementos = inventario.getImplementos();
        for (int i = 0; i < implementos.size(); i++) {
            if (implementos.get(i).getId() == id) {
                implementos.set(i, entity);
                return entity;
            }
        }

        return null;
    }

    @Override
    public boolean delete(int id) {
        return inventario.getImplementos().removeIf(i -> i.getId() == id);
    }
}
