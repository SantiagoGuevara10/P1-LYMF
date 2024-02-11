package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SandboxMapas
{
    private Map<String, String> mapaCadenas;

    public SandboxMapas()
    {
        mapaCadenas = new HashMap<>();
    }

    public List<String> getValoresComoLista()
    {
        return mapaCadenas.values().stream().sorted().collect(Collectors.toList());
    }

    public List<String> getLlavesComoListaInvertida()
    {
        return mapaCadenas.keySet().stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
    }

    public String getPrimera()
    {
        if (mapaCadenas.isEmpty()) {
            return null;
        }
        return mapaCadenas.keySet().stream().min(String::compareTo).orElse(null);
    }

    public String getUltima()
    {
        if (mapaCadenas.isEmpty()) {
            return null;
        }
        return mapaCadenas.values().stream().max(String::compareTo).orElse(null);
    }

    public Collection<String> getLlaves()
    {
        return mapaCadenas.keySet().stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public int getCantidadCadenasDiferentes()
    {
        return (int) mapaCadenas.values().stream().distinct().count();
    }

    public void agregarCadena(String cadena)
    {
        mapaCadenas.put(invertirCadena(cadena), cadena);
    }

    public void eliminarCadenaConLLave(String llave)
    {
        mapaCadenas.remove(llave);
    }

    public void eliminarCadenaConValor(String valor)
    {
        String llave = invertirCadena(valor);
        mapaCadenas.remove(llave);
    }

    public void reiniciarMapaCadenas(List<Object> objetos)
    {
        mapaCadenas.clear();
        for (Object obj : objetos) {
            mapaCadenas.put(invertirCadena(obj.toString()), obj.toString());
        }
    }

    public void volverMayusculas()
    {
        Map<String, String> nuevoMapa = new HashMap<>();
        mapaCadenas.forEach((k, v) -> nuevoMapa.put(k.toUpperCase(), v));
        mapaCadenas = nuevoMapa;
    }

    public boolean compararValores(String[] otroArreglo)
    {
        return mapaCadenas.values().containsAll(List.of(otroArreglo));
    }

    private String invertirCadena(String cadena)
    {
        return new StringBuilder(cadena).reverse().toString();
    }
}
