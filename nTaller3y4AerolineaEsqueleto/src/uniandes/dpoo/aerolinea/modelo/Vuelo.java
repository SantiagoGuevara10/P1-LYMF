package uniandes.dpoo.aerolinea.modelo;

public class Vuelo {
    private String codigo;
    private Avion avion;
    // Otros atributos relevantes para un vuelo

    public Vuelo(String codigo, Avion avion) {
        this.codigo = codigo;
        this.avion = avion;
    }

    // Getters y setters
}