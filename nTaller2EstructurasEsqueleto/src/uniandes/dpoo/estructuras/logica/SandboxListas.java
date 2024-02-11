package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SandboxListas
{
    private List<Integer> listaEnteros;
    private List<String> listaCadenas;

    public SandboxListas()
    {
        listaEnteros = new ArrayList<Integer>();
        listaCadenas = new LinkedList<String>();
    }

    public List<Integer> getCopiaEnteros()
    {
        return new ArrayList<>(listaEnteros);
    }

    public List<String> getCopiaCadenas()
    {
        return new ArrayList<>(listaCadenas);
    }

    public int[] getEnterosComoArreglo()
    {
        int[] arreglo = new int[listaEnteros.size()];
        for (int i = 0; i < listaEnteros.size(); i++) {
            arreglo[i] = listaEnteros.get(i);
        }
        return arreglo;
    }

    public int getCantidadEnteros()
    {
        return listaEnteros.size();
    }

    public int getCantidadCadenas()
    {
        return listaCadenas.size();
    }

    public void agregarEntero(int entero)
    {
        listaEnteros.add(entero);
    }

    public void agregarCadena(String cadena)
    {
        listaCadenas.add(cadena);
    }

    public void eliminarEntero(int valor)
    {
        listaEnteros.removeIf(n -> n == valor);
    }

    public void eliminarCadena(String cadena)
    {
        listaCadenas.remove(cadena);
    }

    public void insertarEntero(int entero, int posicion)
    {
        if (posicion < 0) {
            posicion = 0;
        } else if (posicion > listaEnteros.size()) {
            posicion = listaEnteros.size();
        }
        listaEnteros.add(posicion, entero);
    }

    public void eliminarEnteroPorPosicion(int posicion)
    {
        if (posicion >= 0 && posicion < listaEnteros.size()) {
            listaEnteros.remove(posicion);
        }
    }

    public void reiniciarArregloEnteros(double[] valores)
    {
        listaEnteros.clear();
        for (double valor : valores) {
            listaEnteros.add((int) valor);
        }
    }

    public void reiniciarArregloCadenas(List<Object> objetos)
    {
        listaCadenas.clear();
        for (Object objeto : objetos) {
            listaCadenas.add(objeto.toString());
        }
    }

    public void volverPositivos()
    {
        for (int i = 0; i < listaEnteros.size(); i++) {
            int valor = listaEnteros.get(i);
            if (valor < 0) {
                listaEnteros.set(i, -valor);
            }
        }
    }

    public void organizarEnteros()
    {
        listaEnteros.sort((a, b) -> b - a);
    }

    public void organizarCadenas()
    {
        listaCadenas.sort(String::compareTo);
    }

    public int contarApariciones(int valor)
    {
        int contador = 0;
        for (int entero : listaEnteros) {
            if (entero == valor) {
                contador++;
            }
        }
        return contador;
    }

    public int contarApariciones(String cadena)
    {
        int contador = 0;
        for (String cadenaLista : listaCadenas) {
            if (cadenaLista.equalsIgnoreCase(cadena)) {
                contador++;
            }
        }
        return contador;
    }

    public int contarEnterosRepetidos()
    {
        int contador = 0;
        for (int i = 0; i < listaEnteros.size(); i++) {
            int valor = listaEnteros.get(i);
            for (int j = i + 1; j < listaEnteros.size(); j++) {
                if (valor == listaEnteros.get(j)) {
                    contador++;
                    break;
                }
            }
        }
        return contador;
    }

    public boolean compararArregloEnteros(int[] otroArreglo)
    {
        if (listaEnteros.size() != otroArreglo.length) {
            return false;
        }
        for (int i = 0; i < listaEnteros.size(); i++) {
            if (listaEnteros.get(i) != otroArreglo[i]) {
                return false;
            }
        }
        return true;
    }

    public void generarEnteros(int cantidad, int minimo, int maximo)
    {
        listaEnteros.clear();
        for (int i = 0; i < cantidad; i++) {
            int entero = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
            listaEnteros.add(entero);
        }
    }
}
