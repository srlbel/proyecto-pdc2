package controllers;

import local.gym.models.Inventario;
import local.gym.models.Maquina;
import local.gym.models.Implemento;

public class InventarioController {
    private Inventario inventario;

    public InventarioController() {
        this.inventario = new Inventario();
    }

    public void agregarNuevaMaquina(String nombre, String marca) {
        Maquina maquina = new Maquina(nombre, marca);
        inventario.agregarMaquina(maquina);
    }

    public void agregarNuevoImplemento(String nombre, String tipo) {
        Implemento implemento = new Implemento(nombre, tipo);
        inventario.agregarImplemento(implemento);
    }

    public Inventario getInventario() {
        return inventario;
    }
}
