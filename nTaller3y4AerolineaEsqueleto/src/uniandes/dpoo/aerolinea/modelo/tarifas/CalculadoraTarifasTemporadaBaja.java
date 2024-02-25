package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
    private static final int COSTO_POR_KILOMETRO = 600;
    private static final double DESCUENTO_NATURAL = 0.05; 
    private static final double DESCUENTO_PEQ = 0.002;
    private static final double DESCUENTO_MEDIANAS = 0.1;
    private static final double DESCUENTO_GRANDES = 0.2;

    @Override
    public double calcularTarifa(Vuelo vuelo, Cliente cliente) {
        double distancia = calcularDistanciaVuelo(vuelo);
        double costoBase = distancia * COSTO_POR_KILOMETRO;
        double porcentajeDescuento = calcularPorcentajeDescuento(cliente);
        double costoDespuesDescuento = costoBase * (1 - porcentajeDescuento);
        double valorImpuestos = calcularValorImpuestos(costoDespuesDescuento);
        return costoDespuesDescuento + valorImpuestos;
    }

    @Override
    protected double calcularCostoBase(Vuelo vuelo) {
        double distancia = calcularDistanciaVuelo(vuelo);
        return distancia * COSTO_POR_KILOMETRO;
    }

    @Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {
        
        if (cliente instanceof ClienteNatural) {
            return DESCUENTO_NATURAL;
        } else if (cliente instanceof ClienteCorporativo) {
            
            ClienteCorporativo corporativo = (ClienteCorporativo) cliente;
            if (corporativo.getTamanoEmpresa() < 100) {
                return DESCUENTO_PEQ;
            } else if (corporativo.getTamanoEmpresa() < 500) {
                return DESCUENTO_MEDIANAS;
            } else {
                return DESCUENTO_GRANDES;
            }
        }
        return 0;
    }
}