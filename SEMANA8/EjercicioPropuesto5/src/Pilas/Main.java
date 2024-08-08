/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

/**
 *
 * @author Asus
 */
public class Main {
    public static void main(String[] args) {
        Pila miPila = new Pila();

        boolean equilibrado = miPila.verificarSimbolos();

        if (equilibrado) {
            System.out.println("Los simbolos estan equilibrados en el codigo.");
        } else {
            System.out.println("Los simbolos NO estan equilibrados en el codigo.");
        }
    }
}
