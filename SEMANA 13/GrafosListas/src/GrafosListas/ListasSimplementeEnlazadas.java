/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GrafosListas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class ListasSimplementeEnlazadas {

    private Nodo L;
    
    public ListasSimplementeEnlazadas(){
        L = null;
    }
    
    public boolean esVacia(){
        return L == null;
    }
    
    public Nodo getL() {
        return L;
    }
    
    public void insertaAlInicio(int valor){
        Nodo nuevo = new Nodo(valor);
        nuevo.setSgte(L);
        L = nuevo;
    }
    
    public void insertaAlFinal(int valor){
        Nodo nuevo = new Nodo(valor);
        if(L==null)
            L = nuevo;
        else{
            Nodo p = L;
            while(p.getSgte() != null)
                p = p.getSgte();
        p.setSgte(nuevo);
        }
    }
    
    public void mostrar(DefaultListModel modelo){
        Nodo p = L;
        modelo.removeAllElements();
        while(p != null){
            modelo.addElement(p.getInfo());
            p= p.getSgte();
        }
    }
    
    public void insertarN(int posicion, int valor){
        Nodo nuevo = new Nodo(valor);
        Nodo p = L;
        int c = 1;
        if(posicion==0){
            nuevo.setSgte(L);
            L = nuevo;
        }
        else{
            while(posicion != c){
                c++;
                p = p.getSgte();
            }
            if(posicion == c){
                nuevo.setSgte(p.getSgte());
                p.setSgte(nuevo);
            }
        }
    }
    
//    public void eliminarN(int posicion){
//        int c = 0;
//        if(posicion == 0){
//            L = L.getSgte();
//        }
//        else{
//            Nodo p = L;
//            Nodo ant;
//            while(posicion>c){
//                c++;
//                if(posicion==c){
//                    ant=p;
//                    p=p.getSgte();
//                    ant.setSgte(p.getSgte());
//                }
//                else{
//                    p = p.getSgte();
//                }
//            }
//        }
//    }
    
        public boolean eliminar (int dato){
        if(L.getInfo()==dato){
            L=L.getSgte();
            return true;
        }
        else{
            Nodo ant, p;
            ant = L;
            p=L.getSgte();
            while(p!=null && p.getInfo()!=dato){
                ant=p;
                p=p.getSgte();
            }
            if(p!=null){
                ant.setSgte(p.getSgte());
                return true;
            }
            else
                return false;
        } 
    }

    
    public boolean ordenamiento(){
        Nodo p;
        p = L;        
        while(p!=null && p.getSgte()!=null){
            if(p.getInfo()>p.getSgte().getInfo())
                return false;
            p=p.getSgte();
        }
        return true;
    }
    
    public int contar(){
        int c = 0;
        Nodo p = L;
        while(p!=null){
            c++;
            p = p.getSgte();
        }
        return c;
    }

    
    public Nodo buscar(int valor) {
        Nodo actual = L;
        while (actual != null) {
            if (actual.getInfo() == valor) {
                return actual;
            }
            actual = actual.getSgte();
        }
        return null;
    }

} 

