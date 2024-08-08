/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPropuesto07;

import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class PilaDouble {
    private NodoDouble p;
    
    public PilaDouble(){
        p=null;
    }
    
    public void push(double valor){
        NodoDouble nuevo = new NodoDouble(valor);
        nuevo.setSgte(p);
        p=nuevo;
    }
    
    public double pop(){
        double cima = p.getInfo();
        p = p.getSgte();
        return cima;
    }
    
    public double top(){
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
        NodoDouble actual = p;
        modelo.removeAllElements();
        while(actual!= null){
            modelo.addElement(actual.getInfo());
            actual = actual.getSgte();
        }
    }
    
    public double resultado(String expresionP) {
        PilaDouble pila = new PilaDouble();
        int i, n = expresionP.length();
        double resultado = 0, op2, op1;
        char car;

        for (i = 0; i < n; i++) {
            car = expresionP.charAt(i);
            if (Character.isDigit(car)) {
                pila.push(Double.parseDouble(String.valueOf(car)));
            } else {
                op2 = pila.pop();
                op1 = pila.pop();
                switch (car) {

                    case '+' -> {
                        resultado = op1 + op2;
                    }
                    case '-' -> {
                        resultado = op1 - op2;
                    }
                    case '*' -> {
                        resultado = op1 * op2;
                    }
                    case '/' -> {
                        resultado = op1 / op2;
                    }
                    case '^' -> {
                        resultado =  Math.pow(op1, op2);
                    }
                }
                pila.push(resultado);
            }
        }
        return pila.top();
    }
}
