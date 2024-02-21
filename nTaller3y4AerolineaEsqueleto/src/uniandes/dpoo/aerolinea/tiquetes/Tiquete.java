package uniandes.dpoo.aerolinea.tiquetes;

public class Tiquete {
    private String codigo;
    private String nombrePasajero;
    private String numeroVuelo;
    private double precio;
    // Otros atributos relevantes para un tiquete

    public Tiquete(String codigo, String nombrePasajero, String numeroVuelo, double precio) {
        this.codigo = codigo;
        this.nombrePasajero = nombrePasajero;
        this.numeroVuelo = numeroVuelo;
        this.precio = precio;
    }

    // Getters y setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}