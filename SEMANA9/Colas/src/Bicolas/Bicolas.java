/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bicolas;

import Colas.Nodo;
import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class Bicolas <T>{
    
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    
    public Bicolas(){
        primero = null;
        ultimo = null;
    }
    
    public boolean isEmpty(){
        return primero == null;
    }
    
    public void encolarAlFinal(T valor) {
        Nodo<T> nuevo = new Nodo(valor);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSgte(nuevo);
            ultimo = nuevo;
        }
    }
    
    public void encolarAlInicio(T valor) {
        Nodo<T> nuevo = new Nodo(valor);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setSgte(primero);
            primero = nuevo;
        }
    }
    
    public T frente(){
        if (!isEmpty()) {
            return primero.getInfo();
        }
        return null;
    }
    
    public T ultimoC(){
        if (!isEmpty()) {
            return ultimo.getInfo();
        }
        return null;
    }
    
    public T desencolarAlInicio() {

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
    
    public T desencolarAlFinal() {

        if (!isEmpty()) {
            T valor = ultimo.getInfo();

            if (primero == ultimo) {
                primero = null;
                ultimo = null;
            } else {
                Nodo<T> actual = primero;
                while(actual.getSgte()!= ultimo){
                    actual = actual.getSgte();
                }
                actual.setSgte(null);
                ultimo = actual;
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
