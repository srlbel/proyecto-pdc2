package models;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Maquina> maquinas;
    private List<Implemento> implementos;

    public Inventario() {
        this.maquinas = new ArrayList<>();
        this.implementos = new ArrayList<>();
    }

    public void agregarMaquina(Maquina maquina) {
        maquinas.add(maquina);
    }

    public void agregarImplemento(Implemento implemento) {
        implementos.add(implemento);
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }

    public List<Implemento> getImplementos() {
        return implementos;
    }
}
