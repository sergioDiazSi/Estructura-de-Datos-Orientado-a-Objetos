/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColasPrioridad;

/**
 *
 * @author Asus
 */
public class Cliente {
    private String Nombre;
    private String dni;
    private int prioridad;

    public Cliente(String Nombre, String dni, int prioridad) {
        this.Nombre = Nombre;
        this.dni = dni;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre: ").append(Nombre);
        sb.append("\nDni: ").append(dni);
        sb.append("\nPrioridad: ").append(prioridad);
        return sb.toString();
    }

    
}
