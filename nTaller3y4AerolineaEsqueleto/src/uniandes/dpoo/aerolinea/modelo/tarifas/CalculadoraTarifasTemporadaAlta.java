package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Cliente;


public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
    private static final int COSTO_POR_KM = 1000;
    

    @Override
    public double calcularTarifa(Vuelo vuelo, Cliente cliente) {
        double distancia = calcularDistanciaVuelo(vuelo);
        double costoBase = distancia * COSTO_POR_KM;
        double porcentajeDescuento = calcularPorcentajeDescuento(cliente);
        double costoDespuesDescuento = costoBase * (1 - porcentajeDescuento);
        double valorImpuestos = calcularValorImpuestos(costoDespuesDescuento);
        return costoDespuesDescuento + valorImpuestos;
    }

    @Override
    protected double calcularCostoBase(Vuelo vuelo) {
        double distancia = calcularDistanciaVuelo(vuelo);
        return distancia * COSTO_POR_KM;
    }

    @Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {
        
        return super.calcularPorcentajeDescuento(cliente); 
    }
}