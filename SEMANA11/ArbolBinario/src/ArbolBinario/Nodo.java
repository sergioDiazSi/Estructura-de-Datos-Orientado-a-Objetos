/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolBinario;

/**
 *
 * @author Asus
 */
public class Nodo<T extends Comparable<T>> {
    private T info;
    private Nodo izquierdo;
    private Nodo derecho;
    
    public Nodo(T info){
        this.info = info;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    public Nodo(T info,Nodo izquierdo, Nodo derecho){
        this.info = info;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
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
