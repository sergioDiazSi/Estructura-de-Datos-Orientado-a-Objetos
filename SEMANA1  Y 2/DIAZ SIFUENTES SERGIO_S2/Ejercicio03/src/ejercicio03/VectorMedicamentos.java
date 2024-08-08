/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio03;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class VectorMedicamentos {
    private Medicamento vector[];
    private int totalElementos;
    
    public VectorMedicamentos(){
        vector = new Medicamento[50];
        totalElementos = 0;
    }
    
    public VectorMedicamentos(int limite){
        vector = new Medicamento[limite];
        totalElementos = 0;
    }
    
    public void ordenAlfabeticoSeleccion(){
        int indice_menor,i,j;
        Medicamento temp;
        
        for (i = 0; i < totalElementos - 1; i++) {
            indice_menor = i;
            for (j = i+1 ; j < totalElementos ; j++) {
                if (vector[j].getNombre().compareTo(vector[indice_menor].getNombre())<0) {
                    indice_menor=j;
                }
            }
            temp = vector[i];
            vector[i]=vector[indice_menor];
            vector[indice_menor] = temp;
        }
    }
    
    public void ordenPrecioSeleccion(){
        int indice_menor,i,j;
        Medicamento temp;
        for (i = 0; i < totalElementos - 1; i++) {
            indice_menor = i;
            for (j = i+1 ; j < totalElementos ; j++) {
                if (vector[j].getPrecio()>vector[indice_menor].getPrecio()) {
                    indice_menor=j;
                }
            }
            temp = vector[i];
            vector[i]=vector[indice_menor];
            vector[indice_menor] = temp;
        }
        
    }
    
    public void mostrar(DefaultTableModel modelo){
        Object datos[][] = new Object[totalElementos][4];
        String titulos[] = {"Nombre","Edad","Ventas","Precio"};
        for(int i=0;i<totalElementos;i++){
            datos[i][0]=vector[i].getCodigo();
            datos[i][1]=vector[i].getNombre();
            datos[i][2]=vector[i].getLaboratorio();
            datos[i][3]=vector[i].getPrecio();
        }
        modelo.setDataVector(datos, titulos);
    }
    
    public boolean agregar(Medicamento x){
        if(totalElementos<vector.length){
            vector[totalElementos]=x;
            totalElementos++;
            return true;
        }
        else return false;
    }
    
}
