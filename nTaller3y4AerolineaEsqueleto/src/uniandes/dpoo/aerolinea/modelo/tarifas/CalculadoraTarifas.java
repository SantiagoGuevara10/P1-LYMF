package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Cliente;

public abstract class CalculadoraTarifas {
    protected static final double IMPUESTO = 0.28;

    public abstract double calcularTarifa(Vuelo vuelo, Cliente cliente);

    protected double calcularCostoBase(Vuelo vuelo) {
       
        return 0;
    }

    protected double calcularPorcentajeDescuento(Cliente cliente) {
        
        return 0;
    }

    protected double calcularDistanciaVuelo(Vuelo vuelo) {
        
        return vuelo.getRuta().getDistancia();
    }

    protected double calcularValorImpuestos(double costoBase) {
        return costoBase * IMPUESTO;
    }
}