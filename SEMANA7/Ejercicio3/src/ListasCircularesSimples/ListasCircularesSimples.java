package ListasCircularesSimples;

import javax.swing.DefaultListModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
        } else if (u == null) {
            modelo.removeAllElements();
        }
    }
    
    public int obtenerNumero() {
    if (u == null || u.getSgte() == null) {
        return -1;
    }

    int numeroAleatorio = (int) (Math.random() * 30);
    Nodo p = u.getSgte();
    int numeroObtenido;

        while (p.getInfo() != numeroAleatorio) {
            p = p.getSgte();
        }

        numeroObtenido = p.getInfo();
        

        return numeroObtenido;
}
    
    
        
}
