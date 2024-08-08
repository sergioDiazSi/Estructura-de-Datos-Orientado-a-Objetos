/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

import javax.swing.DefaultListModel;

/**
 *
 * @author Sistemas
 */
public class Pila {
    private Nodo p;
    
    public Pila(){
        p=null;
    }
    
    public void push(char valor){
        Nodo nuevo = new Nodo(valor);
        nuevo.setSgte(p);
        p=nuevo;
    }
    
    public char pop(){
        char cima = p.getInfo();
        p = p.getSgte();
        return cima;
    }
    
    public char top(){
        return p.getInfo();
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
    
    public boolean verificarParentesis(String expresion){
        Pila pc = new Pila();
        int i, n = expresion.length();
        char car;
        for (i = 0; i < n; i++) {
            car = expresion.charAt(i);
            
            if(car=='(')
                pc.push(car);
            else if(car==')'){
                if(pc.isEmpty())
                    return false;
                else{ 
                    pc.pop();
                }
            }
        }
        return pc.isEmpty();
    }
}
