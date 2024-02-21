package uniandes.dpoo.aerolinea.persistencia;

import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public interface IPersistenciaAerolinea {
    /**
     * Carga los datos de la aerolínea desde un archivo.
     * @param archivo El nombre del archivo desde el cual cargar los datos.
     * @param aerolinea La instancia de Aerolinea a la cual cargar los datos.
     * @throws Exception Si ocurre algún error durante la carga de los datos.
     */
    void cargarDatos(String archivo, Aerolinea aerolinea) throws Exception;

    /**
     * Guarda los datos de la aerolínea en un archivo.
     * @param archivo El nombre del archivo en el cual guardar los datos.
     * @param aerolinea La instancia de Aerolinea de la cual guardar los datos.
     * @throws Exception Si ocurre algún error durante el guardado de los datos.
     */
    void guardarDatos(String archivo, Aerolinea aerolinea) throws Exception;
}