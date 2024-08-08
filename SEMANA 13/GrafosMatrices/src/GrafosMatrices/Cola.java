/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GrafosMatrices;

import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class Cola {
    private Nodo primero;
    private Nodo ultimo;
    
    public Cola(){
        primero = null;
        ultimo = null;
    }
    
    public boolean isEmpty(){
        return primero == null;
    }
    
    public void encolar(int valor) {
        Nodo nuevo = new Nodo(valor);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSgte(nuevo);
            ultimo = nuevo;
        }
    }
    
    public int frente() {
        if (!isEmpty()) {
            return primero.getInfo();
        }
        return -1;
    }

    
    public int desencolar() {

        if (!isEmpty()) {
            int valor = primero.getInfo();

            if (primero == ultimo) {
                primero = null;
                ultimo = null;
            } else {
                primero = primero.getSgte();
            }
            return valor;
        }
        return -1;
    }
    
    public void clear(){
        while(primero!=null){
            primero = primero.getSgte();
        }
        ultimo = null;
    }
    
    public void mostrar(DefaultListModel modelo){
        Nodo actual = primero;
        modelo.removeAllElements();
        while(actual!= null){
            modelo.addElement(actual.getInfo());
            actual = actual.getSgte();
        }
    }
}
