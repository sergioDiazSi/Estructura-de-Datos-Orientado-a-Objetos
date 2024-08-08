/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaSimplementeEnlazada;

/**
 *
 * @author Asus
 */
public class Pelicula {
    private String titulo;
    private int horas;
    private int minutos;
    private int segundos;

    public Pelicula(String titulo, int horas, int minutos, int segundos) {
        this.titulo = titulo;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    
    
}
