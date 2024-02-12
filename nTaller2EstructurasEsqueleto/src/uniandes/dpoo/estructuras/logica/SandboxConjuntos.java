package uniandes.dpoo.estructuras.logica;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class SandboxConjuntos {
    private NavigableSet<String> arbolCadenas;

    public SandboxConjuntos() {
        arbolCadenas = new TreeSet<>();
    }

    public List<String> getCadenasComoLista() {
        return new ArrayList<>(arbolCadenas);
    }

    public List<String> getCadenasComoListaInvertida() {
        return new ArrayList<>(arbolCadenas.descendingSet());
    }

    public String getPrimera() {
        if (arbolCadenas.isEmpty()) {
        	return null;
        } else {
        	return arbolCadenas.first();
        }
    }

    public String getUltima() {
        if (arbolCadenas.isEmpty()) {
            return null; 
        } else {
            return arbolCadenas.last();
        }
    }

    public Collection<String> getSiguientes(String cadena) {
        return arbolCadenas.tailSet(cadena, true);
    }

    public int getCantidadCadenas() {
        return arbolCadenas.size();
    }

    public void agregarCadena(String cadena) {
        arbolCadenas.add(cadena);
    }

    public void eliminarCadena(String cadena) {
        arbolCadenas.remove(cadena);
    }

    public void eliminarCadenaSinMayusculasOMinusculas(String cadena) {
        arbolCadenas.removeIf(c -> c.equalsIgnoreCase(cadena));
    }

    public void eliminarPrimera() {
        arbolCadenas.pollFirst();
    }

    public void reiniciarConjuntoCadenas(List<Object> objetos) {
        arbolCadenas.clear();
        for (Object obj : objetos) {
            arbolCadenas.add(obj.toString());
        }
    }

    public void volverMayusculas() {
        NavigableSet<String> nuevoArbolCadenas = new TreeSet<>();
        for (String cadena : arbolCadenas) {
            nuevoArbolCadenas.add(cadena.toUpperCase());
        }
        arbolCadenas = nuevoArbolCadenas;
    }

    public TreeSet<String> invertirCadenas() {
        return new TreeSet<>(arbolCadenas.descendingSet());
    }

    public boolean compararElementos(String[] otroArreglo) {
        for (String cadena : otroArreglo) {
            if (!arbolCadenas.contains(cadena)) {
                return false;
            }
        }
        return true;
    }
}
