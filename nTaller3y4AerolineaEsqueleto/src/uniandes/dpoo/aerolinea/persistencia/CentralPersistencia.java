package uniandes.dpoo.aerolinea.persistencia;


public class CentralPersistencia {
    public static final String JSON = "JSON";
    public static final String PLAIN = "PlainText";

    public static IPersistenciaAerolinea getPersistenciaAerolinea(String tipoArchivo) throws TipoInvalidoException {
        if (JSON.equals(tipoArchivo)) {
            return (IPersistenciaAerolinea) new PersistenciaAereolineaJson();
        } else if (PLAIN.equals(tipoArchivo)) {
            return new PersistenciaAerolineaPlaintext();
        } else {
            throw new TipoInvalidoException("Tipo de archivo no soportado: " + tipoArchivo);
        }
    }

    public static IPersistenciaTiquetes getPersistenciaTiquetes(String tipoArchivo) throws TipoInvalidoException {
        if (JSON.equals(tipoArchivo)) {
            return new PersistenciaTiquetesJson();
        } else {
            throw new TipoInvalidoException("Tipo de archivo no soportado para tiquetes: " + tipoArchivo);
        }
    }
}