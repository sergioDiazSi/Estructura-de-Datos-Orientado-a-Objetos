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
    private Empleado info;
    private Nodo izquierdo;
    private Nodo derecho;
    
    public Nodo(Empleado info){
        this.info = info;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    public Nodo(Empleado info,Nodo izquierdo, Nodo derecho){
        this.info = info;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public Empleado getInfo() {
        return info;
    }

    public void setInfo(Empleado info) {
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
