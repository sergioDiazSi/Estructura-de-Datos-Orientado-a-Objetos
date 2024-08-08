/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

/**
 *
 * @author Asus
 */
public class Nodo {
    private char info;
    private Nodo sgte;
    
    public Nodo(char info){
        this.info = info;
        this.sgte = null;
    }
    
    public Nodo(char info, Nodo sgte){
        this.info = info;
        this.sgte = sgte;
    }
    
    public char getInfo() {
        return info;
    }

    public void setInfo(char info) {
        this.info = info;
    }

    public Nodo getSgte() {
        return sgte;
    }

    public void setSgte(Nodo sgte) {
        this.sgte = sgte;
    }
    
}
