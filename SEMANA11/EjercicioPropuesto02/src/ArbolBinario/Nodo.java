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
    private int info;
    private Nodo izquierdo;
    private Nodo derecho;
    
    public Nodo(int info){
        this.info = info;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    public Nodo(int info,Nodo izquierdo, Nodo derecho){
        this.info = info;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
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
