/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio01;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class VectorPersonas {
    private Persona vector[];
    private int totalElementos;
    
    public VectorPersonas(){
        vector = new Persona[50];
        totalElementos = 0;
    }
    
    public VectorPersonas(int limite){
        vector = new Persona[limite];
        totalElementos = 0;
    }
    
    public void ordenamientoBurbuja(){
        int i,j;
        Persona temp;
        for (i = 0; i < totalElementos; i++) {
            for (j = totalElementos-1; j > i; j--) {
                if(vector[j].getNombre().compareTo(vector[j-1].getNombre())<0){
                    temp = vector[j];
                    vector[j]=vector[j-1];
                    vector[j-1]=temp;
                }
            }
        }
    }
    
    public void mostrar(DefaultTableModel modelo){
        Object datos[][] = new Object[totalElementos][2];
        String titulos[] = {"Nombre","Numero Telefono"};
        for(int i=0;i<totalElementos;i++){
            datos[i][0]=vector[i].getNombre();
            datos[i][1]=vector[i].getTelefono();
        }
        modelo.setDataVector(datos, titulos);
    }
    
    public boolean agregar(Persona x){
        if(totalElementos<vector.length){
            vector[totalElementos]=x;
            totalElementos++;
            return true;
        }
        else return false;
    }
}
