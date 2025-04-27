package models;

public class Persona {

    private int id;
    private String nombre;
    private String telefono;
    private String cedula;
    private String email;

    public Persona(
        int id,
        String nombre,
        String telefono,
        String cedula,
        String email
    ) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.cedula = cedula;
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
