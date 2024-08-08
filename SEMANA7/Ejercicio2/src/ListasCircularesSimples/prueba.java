/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasCircularesSimples;

/**
 *
 * @author Asus
 */
public class prueba {
    public static void main(String[] args) {
        ListasCircularesSimples listaSoldados = new ListasCircularesSimples();
        listaSoldados.insertar("A");
        listaSoldados.insertar("B");
        listaSoldados.insertar("C");
        listaSoldados.insertar("D");
        listaSoldados.insertar("E");

        int n = 3;
        var nombreInicio = "A";

        listaSoldados.juegoRescatePruebaMain(n, nombreInicio);
    }
}
