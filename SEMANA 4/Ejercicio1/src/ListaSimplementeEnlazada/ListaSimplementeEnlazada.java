/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaSimplementeEnlazada;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class ListaSimplementeEnlazada {
    private Nodo L;
    
    public ListaSimplementeEnlazada(){
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
    
    public void eliminarN(int posicion){
        int c = 0;
        if(posicion == 0){
            L = L.getSgte();
        }
        else{
            Nodo p = L;
            Nodo ant;
            while(posicion>c){
                c++;
                if(posicion==c){
                    ant=p;
                    p=p.getSgte();
                    ant.setSgte(p.getSgte());
                }
                else{
                    p = p.getSgte();
                }
            }
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
    
    public void invertir(){
        int totalElementos = contar();
        int c = 2;
        int d = 2;
        Nodo p = L;
        Nodo q;
        int aux;
        while(p!=null){
            q=p.getSgte();
            c=d;
            while(q!=null){
                if(c==totalElementos){
                    aux = p.getInfo();
                    p.setInfo(q.getInfo());
                    q.setInfo(aux);
                }
                c++;
                q = q.getSgte();
            }
            p = p.getSgte();
            d++;
            totalElementos--;
        }
    }
    
    public List<Integer> nUltimos(int n){
        Nodo p = L;
        List<Integer> nUltimo = new ArrayList<>();
        int totalElementos = contar();
        int c=1;
        
        while(p!=null){
            if(c>(totalElementos-n))
                nUltimo.add(p.getInfo());
            c++;
            p=p.getSgte();
        }
        return nUltimo;
    }
    
    public void eliminarIguales(int n) {
        Nodo p = L;
        Nodo ant = null;

        while (p != null) {
            if (p.getInfo() == n) {
                if (ant == null) {
                    L = p.getSgte();
                } else {
                    ant.setSgte(p.getSgte());
                }
            } else {
                ant = p;
            }
            p = p.getSgte();
        }
    }
    
    public boolean sonIguales(ListaSimplementeEnlazada lista2){
        int n =contar();
        int m = lista2.contar();
        if(n==m){
            Nodo p = L;
            Nodo q = lista2.getL();
            while(p!=null){
                if(p.getInfo()!=q.getInfo()){
                    return false;
                }
                p=p.getSgte();
                q=q.getSgte();
            }
            return true;
        }
        else return false;
    }

    private int sumarElementosRecursivo(Nodo p) {
        if (p == null) {
            return 0;
        }
        return p.getInfo() + sumarElementosRecursivo(p.getSgte());
    }

    public int sumarElementos() {
        return sumarElementosRecursivo(L);
    }
}
