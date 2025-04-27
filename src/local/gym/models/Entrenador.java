package models;

import models.Persona;
import models.Turno;

public class Entrenador extends Persona {

    private double salario;
    // se agrega por defecto el turno de la mañana
    private Turno turno = Turno.MANANA;

    public Entrenador(
        int id,
        String nombre,
        String telefono,
        String cedula,
        String email,
        double salario,
        Turno turno
    ) {
        super(id, nombre, telefono, cedula, email);
        this.salario = salario;
        this.turno = turno;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Turno getTurno() {
        return this.turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    // TODO: Agregar los tipos de datos necesarios para la función
    // public void agregarRutinaACliente() {}
}
