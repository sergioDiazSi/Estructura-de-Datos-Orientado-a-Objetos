/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasSimplementeEnlazadas;

/**
 *
 * @author Asus
 */
public class Carreras {
    private String carrera;
    private String codigo;
    private String nombre;
    private int ciclo;
    private int creditos;

    public Carreras(String carrera, String codigo, String nombre, int ciclo, int creditos) {
        this.carrera = carrera;
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciclo = ciclo;
        this.creditos = creditos;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCarrera: ").append(carrera);
        sb.append("\nCodigo: ").append(codigo);
        sb.append("\nNombre: ").append(nombre);
        sb.append("\nCiclo: ").append(ciclo);
        sb.append("\ncreditos: ").append(creditos);
        return sb.toString();
    }
}
