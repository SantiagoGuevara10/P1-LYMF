package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.Arrays;

public class SandboxArreglos
{
    private int[] arregloEnteros;
    private String[] arregloCadenas;

    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    public int[] getCopiaEnteros( )
    {
        int[] copia = new int[arregloEnteros.length];
        System.arraycopy(arregloEnteros, 0, copia, 0, arregloEnteros.length);
        return copia;
    }

    public String[] getCopiaCadenas( )
    {
        String[] copia = new String[arregloCadenas.length];
        System.arraycopy(arregloCadenas, 0, copia, 0, arregloCadenas.length);
        return copia;
    }

    public int getCantidadEnteros( )
    {
        return arregloEnteros.length;
    }

    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    public void agregarEntero( int entero )
    {
        int[] nuevoArreglo = new int[arregloEnteros.length + 1];
        System.arraycopy(arregloEnteros, 0, nuevoArreglo, 0, arregloEnteros.length);
        nuevoArreglo[arregloEnteros.length] = entero;
        arregloEnteros = nuevoArreglo;
    }

    public void agregarCadena( String cadena )
    {
        String[] nuevoArreglo = new String[arregloCadenas.length + 1];
        System.arraycopy(arregloCadenas, 0, nuevoArreglo, 0, arregloCadenas.length);
        nuevoArreglo[arregloCadenas.length] = cadena;
        arregloCadenas = nuevoArreglo;
    }

    public void eliminarEntero( int valor )
    {
        int numEliminados = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                numEliminados++;
            } else {
                arregloEnteros[i - numEliminados] = arregloEnteros[i];
            }
        }
        int[] nuevoArreglo = new int[arregloEnteros.length - numEliminados];
        System.arraycopy(arregloEnteros, 0, nuevoArreglo, 0, nuevoArreglo.length);
        arregloEnteros = nuevoArreglo;
    }

    public void eliminarCadena( String cadena )
    {
        int numEliminados = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
            if (arregloCadenas[i].equals(cadena)) {
                numEliminados++;
            } else {
                arregloCadenas[i - numEliminados] = arregloCadenas[i];
            }
        }
        String[] nuevoArreglo = new String[arregloCadenas.length - numEliminados];
        System.arraycopy(arregloCadenas, 0, nuevoArreglo, 0, nuevoArreglo.length);
        arregloCadenas = nuevoArreglo;
    }

    public void insertarEntero( int entero, int posicion )
    {
        if (posicion < 0)
            posicion = 0;
        if (posicion > arregloEnteros.length)
            posicion = arregloEnteros.length;
        int[] nuevoArreglo = new int[arregloEnteros.length + 1];
        System.arraycopy(arregloEnteros, 0, nuevoArreglo, 0, posicion);
        nuevoArreglo[posicion] = entero;
        System.arraycopy(arregloEnteros, posicion, nuevoArreglo, posicion + 1, arregloEnteros.length - posicion);
        arregloEnteros = nuevoArreglo;
    }

    public void eliminarEnteroPorPosicion( int posicion )
    {
        if (posicion < 0 || posicion >= arregloEnteros.length)
            return;
        int[] nuevoArreglo = new int[arregloEnteros.length - 1];
        System.arraycopy(arregloEnteros, 0, nuevoArreglo, 0, posicion);
        System.arraycopy(arregloEnteros, posicion + 1, nuevoArreglo, posicion, arregloEnteros.length - posicion - 1);
        arregloEnteros = nuevoArreglo;
    }


    public void reiniciarArregloEnteros( double[] valores )
    {
        arregloEnteros = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            arregloEnteros[i] = (int) valores[i];
        }
    }

    public void reiniciarArregloCadenas( Object[] objetos )
    {
        arregloCadenas = new String[objetos.length];
        for (int i = 0; i < objetos.length; i++) {
            arregloCadenas[i] = objetos[i].toString();
        }
    }

    public void volverPositivos( )
    {
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] < 0) {
                arregloEnteros[i] *= -1;
            }
        }
    }

    public void organizarEnteros( )
    {
        Arrays.sort(arregloEnteros);
    }

    public void organizarCadenas( )
    {
        Arrays.sort(arregloCadenas);
    }

    public int contarApariciones( int valor )
    {
        int contador = 0;
        for (int entero : arregloEnteros) {
            if (entero == valor) {
                contador++;
            }
        }
        return contador;
    }

    public int contarApariciones( String cadena )
    {
        int contador = 0;
        for (String str : arregloCadenas) {
            if (str.equalsIgnoreCase(cadena)) {
                contador++;
            }
        }
        return contador;
    }

    public int[] buscarEntero( int valor )
    {
        int contador = 0;
        for (int entero : arregloEnteros) {
            if (entero == valor) {
                contador++;
            }
        }
        int[] posiciones = new int[contador];
        contador = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                posiciones[contador++] = i;
            }
        }
        return posiciones;
    }

    public int[] calcularRangoEnteros( )
    {
        if (arregloEnteros.length == 0) {
            return new int[]{};
        }
        int min = arregloEnteros[0];
        int max = arregloEnteros[0];
        for (int entero : arregloEnteros) {
            if (entero < min) {
                min = entero;
            }
            if (entero > max) {
                max = entero;
            }
        }
        return new int[]{min, max};
    }

    public HashMap<Integer, Integer> calcularHistograma( )
    {
        HashMap<Integer, Integer> histograma = new HashMap<>();
        for (int entero : arregloEnteros) {
            histograma.put(entero, histograma.getOrDefault(entero, 0) + 1);
        }
        return histograma;
    }

    public int contarEnterosRepetidos( )
    {
        HashMap<Integer, Integer> histograma = calcularHistograma();
        int contador = 0;
        for (int valor : histograma.values()) {
            if (valor > 1) {
                contador++;
            }
        }
        return contador;
    }

    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        return Arrays.equals(arregloEnteros, otroArreglo);
    }

    public boolean mismosEnteros( int[] otroArreglo )
    {
        if (arregloEnteros.length != otroArreglo.length) {
            return false;
        }
        int[] copiaArreglo = Arrays.copyOf(arregloEnteros, arregloEnteros.length);
        Arrays.sort(copiaArreglo);
        Arrays.sort(otroArreglo);
        return Arrays.equals(copiaArreglo, otroArreglo);
    }

    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        arregloEnteros = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            arregloEnteros[i] = (int) (Math.random() * (maximo - minimo + 1) + minimo);
        }
    }
}
