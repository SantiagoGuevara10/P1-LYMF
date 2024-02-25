package uniandes.dpoo.aerolinea.tiquetes;

import java.util.HashSet;
import java.util.Set;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Cliente;

public class GeneradorTiquetes {
    private static Set<String> codigos = new HashSet<String>();

    public static Tiquete generarTiquete(Vuelo vuelo, Cliente cliente, int tarifa) {
        String codigo;
        do {
            int numero = (int) (Math.random() * 10e7);
            codigo = String.format("%07d", numero);
        } while (codigos.contains(codigo));

        codigos.add(codigo);
        Tiquete nuevoTiquete = new Tiquete(codigo, vuelo, cliente, tarifa);
        return nuevoTiquete;
    }

    public static void registrarTiquete(Tiquete unTiquete) {
        codigos.add(unTiquete.getCodigo());
    }

    public static boolean validarTiquete(String codigoTiquete) {
        return codigos.contains(codigoTiquete);
    }
}

