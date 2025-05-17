package models;

import java.util.List;

public class Contratista extends Persona {
    private List<Maquina> maquinasAsignadas;
    private Turno turnoAtencion = Turno.MANANA;

    public Contratista(int id, String nombre, String telefono, String cedula, String email,
            List<Maquina> maquinasAsignadas, Turno turnoAtencion) {
        super(id, nombre, telefono, cedula, email);
        this.maquinasAsignadas = maquinasAsignadas;
        this.turnoAtencion = turnoAtencion;
    }

    public List<Maquina> getMaquinasAsignadas() {
        return maquinasAsignadas;
    }

    public void setMaquinasAsignadas(List<Maquina> maquinasAsignadas) {
        this.maquinasAsignadas = maquinasAsignadas;
    }

    public Turno getTurnoAtencion() {
        return turnoAtencion;
    }

    public void setTurnoAtencion(Turno turnoAtencion) {
        this.turnoAtencion = turnoAtencion;
    }

    public void asignarMaquina(Maquina maquina) {
        maquinasAsignadas.add(maquina);
    }
}