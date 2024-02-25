package uniandes.dpoo.aerolinea.modelo;

public class Cliente {
    private String nombre;
    private String identificacion;

    public Cliente(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}