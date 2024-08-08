/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

import java.io.*;

/**
 *
 * @author Asus
 */
public class Main {
    public static void main(String[] args) {
        
        Pila p = new Pila();
    
        p.leerArchivoDeTexto();

        System.out.println("Contenido de la pila empezando por la ultima linea :");
        p.mostrar();
        
    }
}
