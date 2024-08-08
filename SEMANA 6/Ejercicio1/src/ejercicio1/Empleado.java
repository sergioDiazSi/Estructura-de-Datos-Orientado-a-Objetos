/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author Sistemas
 */
public class Empleado {
    private String codigo;
    private String nombre;
    private String apellidos;
    private String sexo;
    private float sueldo;

    public Empleado(String codigo, String nombre, String apellidos, String sexo, float sueldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.sueldo = sueldo;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCodigo: ").append(codigo);
        sb.append("\nNombre: ").append(nombre);
        sb.append("\nApellidos: ").append(apellidos);
        sb.append("\nSexo: ").append(sexo);
        sb.append("\nSueldo: ").append(sueldo);
        return sb.toString();
    }
    
    
}
