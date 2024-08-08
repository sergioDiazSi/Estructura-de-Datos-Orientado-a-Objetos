/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

import EjercicioPropuesto07.PilaDouble;

public class Main {
    public static void main(String[] args) {
        Pila pilaConversion = new Pila();
        PilaDouble pilaResultado = new PilaDouble();
        String expresion = "(9-4*2)/((6+4)/2-1)";
        String resultado = pilaConversion.convertirAPostfija(expresion);
        double resultadoFinal = pilaResultado.resultado(resultado);
        System.out.println("EXPRESION INFIJA: " + expresion);
        System.out.println("EXPRESION POSTFIJA: " + resultado);
        System.out.println("EXPRESION POSTFIJA EVALUADA: " + resultadoFinal);
    }
}