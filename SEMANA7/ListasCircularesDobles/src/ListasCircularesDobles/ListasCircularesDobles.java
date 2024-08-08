/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasCircularesDobles;

import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class ListasCircularesDobles {
    protected Nodo u;
    
    public ListasCircularesDobles(){
        u = null;
    }   

    public Nodo getUltimo() {
        return u;
    }

    public void setUltimo(Nodo u) {
        this.u = u;
    }
    
    public boolean esVacia(){
        return  u == null;
    }
    
    public Nodo getU() {
        return u;
    }
    
    public void insertar(int valor){
        Nodo nuevo = new Nodo(valor);
        if(u == null){
            u=nuevo;
            nuevo.setSgte(nuevo);
            nuevo.setAnt(nuevo);
        }
        else{
            nuevo.setAnt(u);
            nuevo.setSgte(u.getSgte());
            u.getSgte().setAnt(nuevo);
            u.setSgte(nuevo);
            u=nuevo;            
        }
    }
    
    public void insertarAlInicio(int valor){
        Nodo nuevo = new Nodo(valor);
        Nodo p = u.getSgte();
        if(u == null){
            u=nuevo;
            nuevo.setSgte(nuevo);
            nuevo.setAnt(nuevo);
        }
        else{
            nuevo.setAnt(u);
            nuevo.setSgte(p);
            p.setAnt(nuevo);
            u.setSgte(nuevo);                      
        }
    }
    
    public void mostrarHaciaAdelante(DefaultListModel modelo) {
    if (!esVacia()) {
        Nodo p = u.getSgte();
        modelo.removeAllElements();
        do {
            modelo.addElement(p.getInfo());
            p = p.getSgte();
        } while (p != u.getSgte());
    }
    else if(u==null){
        modelo.removeAllElements();
    }
    }
    
    public void mostrarHaciaAtras(DefaultListModel modelo) {
    if (!esVacia()) {
        Nodo p = u;
        modelo.removeAllElements();
        do {
            modelo.addElement(p.getInfo());
            p = p.getAnt();
        } while (p != u);
    }
    else if(u==null){
        modelo.removeAllElements();
    }
    }
    
    public Nodo buscar(int valor){
        Nodo p = u.getSgte();
        
        if(esVacia())
            return null;
        else{
            do{
                if(p.getInfo()==valor){
                    return p;
                }
                p=p.getSgte();
            }while(p!=u.getSgte());
        }
        return null;
    }
    
    public int contar(){
        Nodo p = u.getSgte();
        int c = 0;
        do{
            c++;
            p=p.getSgte();
        }while(p!=u.getSgte());
        
        return c;
    }
    
    
    public boolean eliminar(int valor) {
        Nodo p = u.getSgte();
        int c = contar();

        if (esVacia()) {
            return false;
        } else {
            if (c == 1 && u.getInfo() == valor) {
                u = null;
                return true;
            } else {
                do {
                    if (p.getInfo() == valor) {
                        if (p == u) {
                            p.getAnt().setSgte(p.getSgte());
                            p.getSgte().setAnt(p.getAnt());
                            u = p.getAnt();
                        } else {
                            p.getAnt().setSgte(p.getSgte());
                            p.getSgte().setAnt(p.getAnt());
                        }
                        return true;
                    } else {
                        p = p.getSgte();
                    }
                } while (p != u.getSgte());
            }
        }
        return false;
    }
    
    
    public void ordenar() {
    Nodo p = u.getSgte();
    Nodo q;
    int aux;

    if (p == null || p.getSgte() == null) {
        return;
    }

    do {
        q = p.getSgte();
        do {
            if (p.getInfo() > q.getInfo()) {
                aux = p.getInfo();
                p.setInfo(q.getInfo());
                q.setInfo(aux);
            }
            q = q.getSgte();
        } while (q != u.getSgte());
        p = p.getSgte();
    } while (p != u);
    }
}


