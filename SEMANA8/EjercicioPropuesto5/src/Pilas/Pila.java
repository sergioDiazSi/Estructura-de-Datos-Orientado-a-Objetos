/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

import java.io.*;
import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class Pila {
    private Nodo p;
    private File archivo;
    
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
    
    public boolean verificarSimbolos() {
    Pila pila = new Pila();
    String contenido;
    File archivo = new File("C:/Users/Asus/Desktop/Documentos/IV CICLO - UNT/EDOO/SEMANA8/EjercicioPropuesto5/Prueba.java");

    try (FileReader lector = new FileReader(archivo); BufferedReader lectura = new BufferedReader(lector)) {

        int i, n;
        char caracter;

        while ((contenido = lectura.readLine()) != null) {
            n = contenido.length();

            for (i = 0; i < n; i++) {
                caracter = contenido.charAt(i);

                if (caracter == '{' || caracter == '(' || caracter == '[') {
                    pila.push(caracter);
                } else if (caracter == '}' || caracter == ')' || caracter == ']') {
                    if (pila.isEmpty()) {
                        System.out.println("FALTA: " + obtenerSimboloOpuesto(caracter));
                        return false;
                    }

                    char simboloAbierto = pila.pop();

                    if (!esParBalanceado(simboloAbierto, caracter)) {
                        System.out.println("FALTA: " + obtenerSimboloOpuesto(caracter));
                        return false;
                    }
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    while (!pila.isEmpty()) {
        System.out.println("FALTA: " + obtenerSimboloOpuesto(pila.pop()));
    }

    return true;
}

private boolean esParBalanceado(char simboloAbierto, char simboloCerrado) {
    return (simboloAbierto == '{' && simboloCerrado == '}') ||
           (simboloAbierto == '(' && simboloCerrado == ')') ||
           (simboloAbierto == '[' && simboloCerrado == ']');
}

private char obtenerSimboloOpuesto(char simbolo) {
    return switch (simbolo) {
        case '}' -> '{';
        case ')' -> '(';
        case ']' -> '[';
        default -> ' ';
    };
}

}


