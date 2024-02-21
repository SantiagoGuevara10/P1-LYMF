package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Cliente;

public abstract class CalculadoraTarifas {
    public abstract double calcularTarifa(Vuelo vuelo, Cliente cliente);
}