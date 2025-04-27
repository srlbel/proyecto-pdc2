package models;

import models.Persona;

public class Cliente extends Persona {

    private double mensualidad;
    private int diaRenovacion;
    private boolean haPagado;

    // TODO: Agregar campos
    // private List<Rutina> rutinas;

    public Cliente(
        String nombre,
        String telefono,
        String cedula,
        String email,
        double mensualidad,
        int diaRenovacion,
        boolean haPagado
    ) {
        super(nombre, telefono, cedula, email);
        this.mensualidad = mensualidad;
        this.diaRenovacion = diaRenovacion;
        this.haPagado = haPagado;
    }

    public double getMensualidad() {
        return this.mensualidad;
    }

    public void setMensualidad(double mensualidad) {
        this.mensualidad = mensualidad;
    }

    public int getDiaRenovacion() {
        return this.diaRenovacion;
    }

    public void setDiaRenovacion(int diaRenovacion) {
        this.diaRenovacion = diaRenovacion;
    }

    public boolean getHaPagado() {
        return this.haPagado;
    }

    public void setHaPagado(boolean haPagado) {
        this.haPagado = haPagado;
    }

    public void agregarRutina(Rutina rutina) {
        rutinas.add(rutina);
    }
}
