package uniandes.dpoo.aerolinea.modelo.cliente;

/**
 * Clase que representa a un cliente natural de la aerolínea.
 */
public class ClienteNatural extends Cliente {
    private String fechaNacimiento;
    private String nacionalidad;

    public ClienteNatural(String nombre, String identificacion, String fechaNacimiento, String nacionalidad) {
        super(nombre, identificacion); // Llamada al constructor de la superclase
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
    }

    // Métodos getter y setter para los nuevos atributos
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    // Implementación de métodos abstractos de la clase Cliente (si los hay)

    // Otros métodos específicos de ClienteNatural
}