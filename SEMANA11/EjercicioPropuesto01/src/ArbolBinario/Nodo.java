/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolBinario;

/**
 *
 * @author Asus
 */
public class Nodo {
   private Cursos info;
    private Nodo izquierdo;
    private Nodo derecho;
    
    public Nodo(Cursos info){
        this.info = info;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    public Nodo(Cursos info,Nodo izquierdo, Nodo derecho){
        this.info = info;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public Cursos getInfo() {
        return info;
    }

    public void setInfo(Cursos info) {
        this.info = info;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    } 
}
