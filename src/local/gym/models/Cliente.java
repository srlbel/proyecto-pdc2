package models;

import models.Persona;

public class Cliente extends Persona {

    private int idCliente;
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
        int idCliente,
        double mensualidad,
        int diaRenovacion,
        boolean haPagado
    ) {
        super(nombre, telefono, cedula, email);
        this.idCliente = idCliente;
        this.mensualidad = mensualidad;
        this.diaRenovacion = diaRenovacion;
        this.haPagado = haPagado;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public void setIdClient(int idCliente) {
        this.idCliente = idCliente;
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
}
