/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

/**
 *
 * @author Sistemas
 */
public class Nodo {
   private int info;
    private Nodo sgte;
    
    public Nodo(int info){
        this.info = info;
        this.sgte = null;
    }
    
    public Nodo(int info, Nodo sgte){
        this.info = info;
        this.sgte = sgte;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Nodo getSgte() {
        return sgte;
    }

    public void setSgte(Nodo sgte) {
        this.sgte = sgte;
    } 
}
