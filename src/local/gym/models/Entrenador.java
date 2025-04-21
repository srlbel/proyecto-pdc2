package models;

import models.Persona;
import models.Turno;

public class Entrenador extends Persona {

    private int idEntrenador;
    private double salario;
    // se agrega por defecto el turno de la mañana
    private Turno turno = Turno.MANANA;

    public Entrenador(
        String nombre,
        String telefono,
        String cedula,
        String email,
        int idEntrenador,
        double salario,
        Turno turno
    ) {
        super(nombre, telefono, cedula, email);
        this.idEntrenador = idEntrenador;
        this.salario = salario;
        this.turno = turno;
    }

    public int getIdEntrenador() {
        return this.idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
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
