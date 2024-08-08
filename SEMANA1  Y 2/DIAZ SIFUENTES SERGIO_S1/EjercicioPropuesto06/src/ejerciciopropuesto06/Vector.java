/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopropuesto06;

import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class Vector {
    private double vector[];
    private int totalElementos;

    public Vector() {
        vector = new double[50];
        totalElementos = 0;
    }
    
    public Vector(int limite){
        vector = new double[limite];
        totalElementos = 0;
    }
    
    public boolean agregar(double x){
        if(totalElementos<vector.length){
            vector[totalElementos] = x;
            totalElementos++;
            return true;
        }
        else
            return false;
    }
    
    public double getElemento(int indice) {
        return vector[indice];
    }
    
    public void mostrar(DefaultListModel modelo){
        modelo.removeAllElements();
        for(int i=0;i<totalElementos;i++)
            modelo.addElement(vector[i]);
    }
    
    private int buscar(double v[],double numero,int elementos){
        if(v[elementos-1] == numero)
            return elementos - 1;
        else
            if(elementos-1 == 0)
                return -1;
            else    
                return buscar(v,numero,elementos-1);
    }
    
    public int buscar(double n){
        return buscar(vector,n,totalElementos);
    }

    public int getTotalElementos() {
        return totalElementos;
    }
    
    
}
