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

    public Nodo getP(){
        return p;
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
    public String convertirAPostfija(String expresion) {
    Pila pc = new Pila();
    String cad = "";
    int i, n = expresion.length();
    char car;
    for (i = 0; i < n; i++) {
        car = expresion.charAt(i);

        if (car == '(') {
            pc.push(car);
        } else if (Character.isDigit(car)) {
            cad += car;
        } else if (car == '+' || car == '-') {
            while (!pc.isEmpty() && (pc.top() == '+' || pc.top() == '-' || pc.top() == '*' || pc.top() == '/' || pc.top() == '^')) {
                cad += pc.pop();
            }
            pc.push(car);
        } else if (car == '*' || car == '/') {
            while (!pc.isEmpty() && (pc.top() == '*' || pc.top() == '/' || pc.top() == '^')) {
                cad += pc.pop();
            }
            pc.push(car);
        } else if (car == '^') {
            pc.push(car);
        } else if (car == ')') {
            while (!pc.isEmpty() && pc.top() != '(') {
                cad += pc.pop();
            }
            if (pc.isEmpty()) {
                return "PARENTESIS MAL ESCRITOS";
            }
            pc.pop();
        }
    }

    while (!pc.isEmpty()) {
        if (pc.top() == '(') {
            return "PARENTESIS MAL ESCRITOS";
        }
        cad += pc.pop();
    }

    return cad;
}

    
//    public void resultado(String expresionP){
//        Pila pila = new Pila();
//        String cad;
//        cad = convertirAPostfija(expresionP);        
//        int i, n = cad.length(),resultado,op2,op1;
//        char car;
//        
//        for (i = 0; i < n; i++) {
//            car = cad.charAt(i);
//            if(Character.isDigit(car))
//                pila.pushInt(Character.getNumericValue(car));
//            
//            switch(car){
//                case '+' -> {
//                    op2 = pila.popInt();
//                    op1 = pila.popInt();
//                    resultado = op1 + op2;
//                    pila.pushInt(resultado);
//                }
//                case '-' -> {
//                    op2 = pila.popInt();
//                    op1 = pila.popInt();
//                    resultado = op1 - op2;
//                    pila.pushInt(resultado);
//                }
//                case '*' -> {
//                    op2 = pila.popInt();
//                    op1 = pila.popInt();;
//                    resultado = op1 * op2;
//                    pila.pushInt(resultado);
//                }
//                case '/' -> {
//                    op2 = pila.popInt();
//                    op1 = pila.popInt();
//                    resultado = op1 / op2;
//                    pila.pushInt(resultado);
//                }
//                case '^' -> {
//                    op2 = pila.popInt();
//                    op1 = pila.popInt();
//                    resultado = (int) Math.pow(op1, op2);
//                    pila.pushInt(resultado);
//                }    
//            }
//        }
//        System.out.println("Resultado: " + pila.popInt());
//    }

    
    
}
