package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.modelo.Cliente;
import org.json.JSONObject;

public class ClienteCorporativo extends Cliente {
    private String nombreEmpresa;
    private int tamanoEmpresa;

    public ClienteCorporativo(String nombre, String identificacion, String nombreEmpresa, int tamanoEmpresa) {
        super(nombre, identificacion);
        this.nombreEmpresa = nombreEmpresa;
        this.tamanoEmpresa = tamanoEmpresa;
    }

    // Métodos getter y setter para nombreEmpresa y tamanoEmpresa
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getTamanoEmpresa() {
        return tamanoEmpresa;
    }

    public void setTamanoEmpresa(int tamanoEmpresa) {
        this.tamanoEmpresa = tamanoEmpresa;
    }

    public static ClienteCorporativo cargarDesdeJSON(JSONObject cliente) {
        String nombre = cliente.getString("nombre");
        String identificacion = cliente.getString("identificacion");
        String nombreEmpresa = cliente.getString("nombreEmpresa");
        int tamanoEmpresa = cliente.getInt("tamanoEmpresa");
        return new ClienteCorporativo(nombre, identificacion, nombreEmpresa, tamanoEmpresa);
    }

    public JSONObject salvarEnJSON() {
        JSONObject jobject = new JSONObject();
        jobject.put("nombre", getNombre());
        jobject.put("identificacion", getIdentificacion());
        jobject.put("nombreEmpresa", this.nombreEmpresa);
        jobject.put("tamanoEmpresa", this.tamanoEmpresa);
        return jobject;
    }
}
