package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.modelo.Cliente;

/**
 
 */
public class ClienteNatural extends Cliente {
    private String fechaNacimiento;
    private String nacionalidad;

    public ClienteNatural(String nombre, String identificacion, String fechaNacimiento, String nacionalidad) {
        super(nombre, identificacion); 
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
    }

    
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

    

    
}