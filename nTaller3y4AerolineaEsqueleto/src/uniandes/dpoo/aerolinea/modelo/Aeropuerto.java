package uniandes.dpoo.aerolinea.modelo;

public class Aeropuerto {
    private String nombre;
    private String codigo;
    private double latitud;
    private double longitud;

    private static final double RADIO_TERRESTRE = 6371.0; // En kilómetros

    public Aeropuerto(String nombre, String codigo, double latitud, double longitud) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    // Getters y métodos adicionales
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public static int calcularDistancia(Aeropuerto aeropuerto1, Aeropuerto aeropuerto2) {
        double latitud1 = Math.toRadians(aeropuerto1.getLatitud());
        double longitud1 = Math.toRadians(aeropuerto1.getLongitud());
        double latitud2 = Math.toRadians(aeropuerto2.getLatitud());
        double longitud2 = Math.toRadians(aeropuerto2.getLongitud());

        double deltaLatitud = latitud2 - latitud1;
        double deltaLongitud = longitud2 - longitud1;

        double a = Math.sin(deltaLatitud / 2) * Math.sin(deltaLatitud / 2) +
                   Math.cos(latitud1) * Math.cos(latitud2) *
                   Math.sin(deltaLongitud / 2) * Math.sin(deltaLongitud / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distancia = RADIO_TERRESTRE * c;

        return (int) Math.round(distancia);
    }
}
