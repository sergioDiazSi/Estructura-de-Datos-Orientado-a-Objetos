/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio02;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class VectorEmpleados {
    private Empleado vector[];
    private int totalElementos;
    
    public VectorEmpleados(){
        vector = new Empleado[50];
        totalElementos = 0;
    }
    
    public VectorEmpleados(int limite){
        vector = new Empleado[limite];
        totalElementos = 0;
    }
    
    public void ordenamientoInsercion(){
        int i,j;
        Empleado temp;
        
        for (i = 0; i < totalElementos; i++) {
            temp = vector[i];
            j=i;
            while(j>0 && temp.getVentas()>vector[j-1].getVentas()){
                vector[j]=vector[j-1];
                j--;
            }
            vector[j] = temp;
        }
    }
    
        public void mostrar(DefaultTableModel modelo){
        Object datos[][] = new Object[totalElementos][3];
        String titulos[] = {"Nombre","Edad","Ventas"};
        for(int i=0;i<totalElementos;i++){
            datos[i][0]=vector[i].getNombre();
            datos[i][1]=vector[i].getEdad();
            datos[i][2]=vector[i].getVentas();
        }
        modelo.setDataVector(datos, titulos);
    }
    
    public boolean agregar(Empleado x){
        if(totalElementos<vector.length){
            vector[totalElementos]=x;
            totalElementos++;
            return true;
        }
        else return false;
    }
}
