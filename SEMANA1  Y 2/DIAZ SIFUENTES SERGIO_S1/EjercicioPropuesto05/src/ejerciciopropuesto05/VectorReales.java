/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopropuesto05;

import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class VectorReales {
    
    private double vector[];
    private int totalElementos;

    public VectorReales() {
        vector = new double[10];
        totalElementos = 0;
    }
    
    public VectorReales(int limite) {
        vector = new double[limite];
        totalElementos = 0;
    }
    
    public boolean agregar(double valor){
        if(totalElementos<vector.length)
        {
            vector[totalElementos]=valor;
            totalElementos++;
            return true;
        }
        else return false;
    }
    
    public int getTotalElementos(){
        return totalElementos;
    }
    
    public double devolverElemento(int indice){
        return vector[indice];
    }

    public void mostrar(DefaultListModel modelo){
        int i;
        modelo.removeAllElements();
        for (i = 0; i < totalElementos; i++) {
            modelo.addElement(vector[i]);
        }
    }
    
    private double productoElementos(double x[],int n){
        if(n==0){
            return 1;
        }
        else
            return x[n-1] * productoElementos(x,n-1);
    }
    
    public double productoElementos(){
        return productoElementos(vector,totalElementos);
    }
}
