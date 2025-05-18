package controllers;

import java.util.List;

import models.Inventario;
import models.Maquina;

public class MaquinaController implements IController<Maquina> {
    private Inventario inventario;

    public MaquinaController(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public List<Maquina> getAll() {
        return inventario.getMaquinas();
    }

    @Override
    public Maquina getById(int id) {
        for (Maquina maquina : inventario.getMaquinas()) {
            if (maquina.getId() == id) {
                return maquina;
            }
        }
        return null;
    }

    @Override
    public Maquina create(Maquina entity) {
        inventario.agregarMaquina(entity);
        return entity;
    }

    @Override
    public Maquina update(int id, Maquina entity) {
        List<Maquina> maquinas = inventario.getMaquinas();
        for (int i = 0; i < maquinas.size(); i++) {
            if (maquinas.get(i).getId() == id) {
                maquinas.set(i, entity);
                return entity;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return inventario.getMaquinas().removeIf(m -> m.getId() == id);
    }
}
