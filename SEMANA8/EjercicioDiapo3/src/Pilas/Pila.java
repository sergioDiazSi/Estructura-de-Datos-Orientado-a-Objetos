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
    
    public void push(int valor){
        Nodo nuevo = new Nodo(valor);
        nuevo.setSgte(p);
        p=nuevo;
    }
    
    public int pop(){
        int cima = p.getInfo();
        p = p.getSgte();
        return cima;
    }
    
    public int top(){
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
    
    public String conversion(int numero, int b){
        Pila p = new Pila();
        
        int res;
        while(numero>0){
            res = numero % b;
            p.push(res);
            numero = numero/b;
        }
        int valor;
        String cad = "";
        while(!p.isEmpty()){
            valor = p.pop();
            if(valor<10)
                cad = cad + String.valueOf(valor);
            else
                cad = cad + (char)(valor+55);
        }
        return cad;
    }
}
