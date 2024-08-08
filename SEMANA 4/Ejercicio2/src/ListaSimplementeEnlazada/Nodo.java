/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaSimplementeEnlazada;

/**
 *
 * @author Asus
 */
public class Nodo {
    private Pelicula info;
    private Nodo sgte;
    
    public Nodo(Pelicula info){
        this.info = info;
        this.sgte = null;
    }
    
    public Nodo(Pelicula info, Nodo sgte){
        this.info = info;
        this.sgte = sgte;
    }

    public Pelicula getInfo() {
        return info;
    }

    public void setInfo(Pelicula info) {
        this.info = info;
    }

    public Nodo getSgte() {
        return sgte;
    }

    public void setSgte(Nodo sgte) {
        this.sgte = sgte;
    }
    
    
}
