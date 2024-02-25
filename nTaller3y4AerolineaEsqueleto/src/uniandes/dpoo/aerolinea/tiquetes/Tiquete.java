package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Cliente;

public class Tiquete {
    private String codigo;
    private Vuelo vuelo;
    private Cliente cliente;
    private int tarifa;
    private boolean usado;

    public Tiquete(String codigo, Vuelo vuelo, Cliente cliente, int tarifa) {
        this.codigo = codigo;
        this.vuelo = vuelo;
        this.cliente = cliente;
        this.tarifa = tarifa;
        this.usado = false;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void marcarComoUsado() {
        this.usado = true;
    }

    public boolean esUsado() {
        return usado;
    }
}