/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasCircularesDobles;

/**
 *
 * @author Asus
 */
public class Alumno {
    private String codigo;
    private String nombre;
    private String apellidos;
    private String correo;
    private float notas;

    public Alumno(String codigo, String nombre, String apellidos, String correo, float notas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.notas = notas;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public float getNotas() {
        return notas;
    }

    public void setNotas(float notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCodigo:").append(codigo);
        sb.append("\nNombres: ").append(nombre);
        sb.append("\nApellidos: ").append(apellidos);
        sb.append("\nCorreo: ").append(correo);
        sb.append("\nNota: ").append(notas);
        return sb.toString();
    }
    
    
    
}
