package uniandes.dpoo.aerolinea.modelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vuelo {
    private String codigo;
    private Avion avion;
    private Ruta ruta;
    private String fecha;
    private List<Tiquete> tiquetes;

    public Vuelo(String codigo, Avion avion, Ruta ruta, String fecha) {
        this.codigo = codigo;
        this.avion = avion;
        this.ruta = ruta;
        this.fecha = fecha;
        this.tiquetes = new ArrayList<>();
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public Avion getAvion() {
        return avion;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public String getFecha() {
        return fecha;
    }

    public List<Tiquete> getTiquetes() {
        return tiquetes;
    }

    // Método para agregar un tiquete al vuelo
    public void agregarTiquete(Tiquete tiquete) {
        this.tiquetes.add(tiquete);
    }

    // Método para vender tiquetes
    public boolean venderTiquetes(Cliente cliente, int cantidad, int tarifa) {
        
        if (tiquetes.size() + cantidad > avion.getCapacidad()) {
            return false; 
        }
        for (int i = 0; i < cantidad; i++) {
            Tiquete nuevoTiquete = new Tiquete(codigo, null, cliente, i);
            tiquetes.add(nuevoTiquete);
        }
        return true;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vuelo vuelo = (Vuelo) obj;
        return Objects.equals(codigo, vuelo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}