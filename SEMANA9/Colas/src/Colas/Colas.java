/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 * @param <T>
 */

public class Colas<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    
    public Colas(){
        primero = null;
        ultimo = null;
    }
    
    public boolean isEmpty(){
        return primero == null;
    }
    
    public void encolar(T valor) {
        Nodo<T> nuevo = new Nodo(valor);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSgte(nuevo);
            ultimo = nuevo;
        }
    }
    
    public T frente() {
        if (!isEmpty()) {
            return primero.getInfo();
        }
        return null;
    }

    
    public T desencolar() {

        if (!isEmpty()) {
            T valor = primero.getInfo();

            if (primero == ultimo) {
                primero = null;
                ultimo = null;
            } else {
                primero = primero.getSgte();
            }
            return valor;
        }
        return null;
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
