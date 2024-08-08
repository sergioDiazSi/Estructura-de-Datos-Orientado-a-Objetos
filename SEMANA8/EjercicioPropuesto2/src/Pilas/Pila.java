/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class Pila {
   private Nodo p;
    
    public Pila(){
        p=null;
    }

    public void push(int valor)
    {
        Nodo nuevo = new Nodo(valor);
        nuevo.setSgte(p);
        p=nuevo;
    }
    
    public int pop(){
        int cima=p.getInfo();
        p=p.getSgte();
        return cima;
    }

    public int top(){
        return p.getInfo();
    }
    
    public Nodo getP(){
        return p;
    }
    
    public void clear(){
        while(p!=null){
            p=p.getSgte();
        }
    }
    
    public boolean isEmpty(){
        return p==null;
    }
    
    public void mostrar(DefaultListModel modelo){
        Nodo actual = p;
        modelo.removeAllElements();
        while(actual!= null){
            modelo.addElement(actual.getInfo());
            actual = actual.getSgte();
        }
    }
    
    public void cambiar(int numeroACambiar, int nuevo) {
        Pila pa = new Pila();
        int c;

        Nodo actual = p;
        while (actual != null) {
            c = pop();

            if (c != numeroACambiar) {
                pa.push(c);
            } else {
                pa.push(nuevo);
            }
            actual = actual.getSgte();
        }
        actual = pa.getP();
        while (actual != null) {
            push(actual.getInfo());
            actual = actual.getSgte();
        }        
    }
}
