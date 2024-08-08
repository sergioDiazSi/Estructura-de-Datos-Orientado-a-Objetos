/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciopropuesto01;

/**
 *
 * @author Asus
 */
public class EjercicioPropuesto01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear un objeto NumerosEnteros
        NumerosEnteros numerosEnteros = new NumerosEnteros(1111);

        // Imprimir el número original
        System.out.println("Representación binaria: " + numerosEnteros.getNumero());

        // Obtener y mostrar la representación decimal
        int decimalRepresentation = numerosEnteros.decimal();
        System.out.println("Representación decimal: " + decimalRepresentation);
    }
    
}
