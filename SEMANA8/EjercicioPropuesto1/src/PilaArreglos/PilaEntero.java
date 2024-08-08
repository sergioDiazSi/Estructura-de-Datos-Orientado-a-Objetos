package PilaArreglos;

import javax.swing.DefaultListModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sistemas
 */
public class PilaEntero {
    private int pila[];
    private int totalElementos;

    
    public PilaEntero(){
        pila = new int [50];
        totalElementos = 0;
    }
    
    public PilaEntero(int limite){
        pila = new int [limite];
        totalElementos = 0;
    }
    
    public void push(int valor){
        if(totalElementos<pila.length){
            pila[totalElementos] = valor;
            totalElementos++;
        }
    }
    
    public int pop(){
        int dato = 0;
        if (totalElementos>0){
            totalElementos--;
            dato = pila[totalElementos];
        }
        return dato;
    }
    
    public int top(){
        return pila[totalElementos-1];
    }
    
    public void clear(){
        totalElementos = 0;
    }
    
    public boolean isEmpty(){
        return totalElementos == 0;
    }
    
    public void mostrar(DefaultListModel modelo){
        int i;
        modelo.removeAllElements();
        
        for (i = totalElementos-1 ; i >= 0; i--) {
            modelo.addElement(pila[i]);
        }
    }
}
