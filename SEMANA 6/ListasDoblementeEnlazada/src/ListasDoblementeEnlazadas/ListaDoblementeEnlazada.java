/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasDoblementeEnlazadas;

import javax.swing.DefaultListModel;

/**
 *
 * @author Sistemas
 */
public class ListaDoblementeEnlazada {
    protected Nodo primero;
    protected Nodo ultimo;
    
    public ListaDoblementeEnlazada(){
        primero = null;
        ultimo = null;
    }
    
    public Nodo getPrimero(){
        return primero;
    }
    
    public void setPrimero(Nodo primero){
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }
    
    public boolean esVacia(){
        return primero == null && ultimo == null;
    }
    
    public void insertaAlInicio(int valor){
        Nodo nuevo = new Nodo(valor);
        if(primero == null){
            nuevo.setSgte(null);
            nuevo.setAnt(null);
            primero = nuevo;
            ultimo = nuevo;
        }
        else{
            nuevo.setSgte(primero);
            nuevo.setAnt(null);
            primero.setAnt(nuevo);
            primero = nuevo;
        }
    }
    
    public void insertaAlFinal(int valor){
        Nodo nuevo = new Nodo(valor);
        if(primero == null){
            nuevo.setSgte(null);
            nuevo.setAnt(null);
            primero = nuevo;
            ultimo = nuevo;
        }
        else{
            nuevo.setSgte(null);
            nuevo.setAnt(ultimo);
            ultimo.setSgte(nuevo);
            ultimo = nuevo;
        }
    }
    
    public int contar(){
        int c = 0;
        Nodo p = primero;
        while(p!=null){
            c++;
            p = p.getSgte();
        }
        return c;
    }
    
    public void mostrarHaciaAdelante(DefaultListModel modelo){
        Nodo p = primero;
        modelo.removeAllElements();
        while(p!=null){
            modelo.addElement(p.getInfo());
            p = p.getSgte();
        }
    }
    
    public void mostrarHaciaAtras(DefaultListModel modelo){
        Nodo p = ultimo;
        modelo.removeAllElements();
        while(p!=null){
            modelo.addElement(p.getInfo());
            p = p.getAnt();
        }
    }
    
    public Nodo buscar(int dato){
        Nodo p = primero;
        while(p!=null){
            if(p.getInfo()==dato)
                return p;
            p=p.getSgte();
        }
        return null;
    }
    
    public boolean eliminar(int dato){
        if(primero.getInfo()==dato){
            if(primero.getSgte()==null){
                primero = null;
                ultimo = null;
            }
            else{
                primero = primero.getSgte();
                primero.setAnt(null);
            }
            return true;
        }
        else{
            Nodo p = primero.getSgte();
            while(p!=null && p.getInfo()!=dato)
                p=p.getSgte();
            if(p!=null){
                if(p==ultimo){
                    ultimo = ultimo.getAnt();
                    ultimo.setSgte(null);
                }
                else{
                    p.getAnt().setSgte(p.getSgte());
                    p.getSgte().setAnt(p.getAnt());
                }
                return true;
            }      
            else return false;
        }        
    }
    
    public void ordenar(){
        Nodo p,q;
        int aux;
        p=primero;
        while(p.getSgte()!=null){
            q=p.getSgte();
            while(q!=null){
                if(p.getInfo()>q.getInfo()){
                    aux = p.getInfo();
                    p.setInfo(q.getInfo());
                    q.setInfo(aux);
                }
                q=q.getSgte();
            }
            p = p.getSgte();
        }
    }
}
