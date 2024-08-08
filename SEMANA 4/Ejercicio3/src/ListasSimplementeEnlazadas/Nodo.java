/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasSimplementeEnlazadas;

/**
 *
 * @author Asus
 */
public class Nodo {
    private Carreras info;
    private Nodo sgte;
    
    public Nodo(Carreras info){
        this.info = info;
        this.sgte = null;
    }
    
    public Nodo(Carreras info, Nodo sgte){
        this.info = info;
        this.sgte = sgte;
    }

    public Carreras getInfo() {
        return info;
    }

    public void setInfo(Carreras info) {
        this.info = info;
    }

    public Nodo getSgte() {
        return sgte;
    }

    public void setSgte(Nodo sgte) {
        this.sgte = sgte;
    }
    
}
