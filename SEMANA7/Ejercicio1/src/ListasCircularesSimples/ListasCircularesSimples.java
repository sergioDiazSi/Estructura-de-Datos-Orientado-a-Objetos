/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasCircularesSimples;

import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class ListasCircularesSimples {
    private Nodo u;
    
    public ListasCircularesSimples(){
        u = null;
    }
    
    public boolean esVacia(){
        return u == null;
    }
    
    public Nodo getU() {
        return u;
    }
    
    public void insertar(int valor){
        Nodo nuevo = new Nodo(valor);
        if(u==null){
            u=nuevo;
            nuevo.setSgte(u);
        }
        else{
            nuevo.setSgte(u.getSgte());
            u.setSgte(nuevo);
            u=nuevo;
        }
    }
    
    public void mostrar(DefaultListModel modelo) {
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
    
    public int contar(){
        Nodo p = u.getSgte();
        int c = 0;
        do{
            c++;
            p=p.getSgte();
        }while(p!=u.getSgte());
        
        return c;
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
    
    public ListasCircularesSimples pares(){
        ListasCircularesSimples par = new ListasCircularesSimples();
        
        Nodo p = u.getSgte();
        
        if(esVacia())
            return null;
        else{
            do{
                if(p.getInfo() % 2 == 0){
                    par.insertar(p.getInfo());
                }
                p=p.getSgte();
            }while(p!=u.getSgte());
        }
        return par;
    }
    
    public boolean iguales(ListasCircularesSimples lista2) {
        int n = contar();
        int m = lista2.contar();
        if (n == 0 && esVacia()) {
            return false;
        } else {
            if (n == m) {
                Nodo p = u.getSgte();
                Nodo q = lista2.getU().getSgte();

                do {
                    if (p.getInfo() != q.getInfo()) {
                        return false;
                    }
                    p = p.getSgte();
                    q = q.getSgte();
                } while (p != u.getSgte());
                return true;
            } else {
                return false;
            }
        }
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
