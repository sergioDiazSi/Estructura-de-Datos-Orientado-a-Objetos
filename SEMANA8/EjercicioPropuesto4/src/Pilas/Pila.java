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
public class Pila {
   private Nodo p;
    private File archivo;
    
    public Pila(){
        p=null;
    }

    public void push(String valor)
    {
        Nodo nuevo = new Nodo(valor);
        nuevo.setSgte(p);
        p=nuevo;
    }
    
    public String pop(){
        String cima=p.getInfo();
        p=p.getSgte();
        return cima;
    }

    public String top(){
        return p.getInfo();
    }
    
    public Nodo getP(){
        return p;
    }
    
    public void clear(){
        while(p!=null){
            p=p.getSgte();
        }
    }
    
    public boolean isEmpty(){
        return p==null;
    }
    
//    public void mostrar(DefaultListModel modelo){
//        Nodo actual = p;
//        modelo.removeAllElements();
//        while(actual!= null){
//            modelo.addElement(actual.getInfo());
//            actual = actual.getSgte();
//        }
//    }
    public void mostrar() {
    Nodo actual = p;
    while (actual != null) {
        System.out.println(actual.getInfo());
        actual = actual.getSgte();
    }
}
    
    public void leerArchivoDeTexto(){
        String contenido;
        archivo = new File("C:/Users/Asus/Desktop/Documentos/IV CICLO - UNT/EDOO/SEMANA8/EjercicioPropuesto4/Archivo.txt");
        try{
            FileReader lector = new FileReader(archivo);
            BufferedReader lectura = new BufferedReader(lector);
            
            while ((contenido = lectura.readLine()) != null) {
            push(contenido);
        }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
