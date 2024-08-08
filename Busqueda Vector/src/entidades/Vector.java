/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import javax.swing.DefaultListModel;

/**
 *
 * @author Jose Luis
 */
public class Vector {
    
    private double vector[];
    private int n;

    public Vector() {
        vector = new double[50];
        n = 0;
    }
    
    public Vector(int limite){
        vector = new double[limite];
        n = 0;
    }
    
    public boolean agregar(double elemento){
        if(n<vector.length){
            vector[n] = elemento;
            n++;
            return true;
        }
        else
            return false;
    }
    
    public boolean eliminar(int indice){
        if(indice<n){
            for(int i=indice;i<n;i++)
                vector[i]=vector[i+1];
            n--;
            return true;
        }
        else
            return false;
    }

    public double[] getVector() {
        return vector;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public double getElemento(int indice) {
        return vector[indice];
    }
    
    public void mostrarElementos(DefaultListModel modelo){
        modelo.removeAllElements();
        for(int i=0;i<n;i++)
            modelo.addElement(vector[i]);
    }
    
    private int buscar(double v[],double num,int elementos){
        if(v[elementos-1] == num)
            return elementos - 1;
        else
            if(elementos-1 == 0)
                return -1;
            else    
                return buscar(v,num,elementos-1);
    }
    
    public int buscar(double numerito){
        return buscar(vector,numerito,n);
    }
    
}
