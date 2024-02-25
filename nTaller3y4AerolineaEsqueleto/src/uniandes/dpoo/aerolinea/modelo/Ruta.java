package uniandes.dpoo.aerolinea.modelo;

public class Ruta {
    private String codigoRuta;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private int distancia; // La distancia entre los aeropuertos de origen y destino

    public Ruta(String codigoRuta, Aeropuerto origen, Aeropuerto destino) {
        this.codigoRuta = codigoRuta;
        this.origen = origen;
        this.destino = destino;
        this.distancia = Aeropuerto.calcularDistancia(origen, destino);
    }

    // Getters
    public String getCodigoRuta() {
        return codigoRuta;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public int getDistancia() {
        return distancia;
    }
}