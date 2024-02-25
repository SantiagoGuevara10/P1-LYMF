package uniandes.dpoo.aerolinea.modelo;

public class Avion {
    private String modelo;
    private int capacidad;

    public Avion(String modelo, int capacidad) {
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    // Getters y setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}