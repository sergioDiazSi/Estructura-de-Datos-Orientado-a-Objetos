/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasCircularesSimples;

/**
 *
 * @author Asus
 */
public class Nodo {
    private String info;
    private Nodo sgte;
    
    public Nodo(String info){
        this.info = info;
        this.sgte = null;
    }
    
    public Nodo(String info, Nodo sgte){
        this.info = info;
        this.sgte = sgte;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Nodo getSgte() {
        return sgte;
    }

    public void setSgte(Nodo sgte) {
        this.sgte = sgte;
    }
    
    
}
